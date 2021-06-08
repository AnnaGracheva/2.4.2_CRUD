package web.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    public List<User> listOfUsers() {
        String queryString = "FROM User";

        Query query = entityManager.createQuery(queryString);

        return (List<User>) query.getResultList();
    }

    public User userById(Long id) {
        User user = (User) entityManager.find(User.class, id);
        return user;
    }

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public void deleteUser(Long id) {
        User user = userById(id);
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            entityManager.remove(entityManager.merge(user));
        }
    }

}
