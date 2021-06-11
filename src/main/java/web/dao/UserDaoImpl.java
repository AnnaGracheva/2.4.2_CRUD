package web.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<User> listOfUsers() {
        String queryString = "FROM User";

        Query query = entityManager.createQuery(queryString);

        return (List<User>) query.getResultList();
    }

    @Override
    public User userById(Long id) {
        User user = (User) entityManager.find(User.class, id);
        return user;
    }
    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = userById(id);
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            entityManager.remove(entityManager.merge(user));
        }
    }

    @Override
    public User getName(String username) {
        TypedQuery<User> userTypedQuery = entityManager.createQuery("select  u from User u where u.username =:username", User.class);
        userTypedQuery.setParameter("username", username);
        return userTypedQuery.getResultList().stream().findAny().orElse(null);
    }
}
