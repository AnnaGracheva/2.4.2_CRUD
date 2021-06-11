package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional(readOnly = true)
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Role getRole(String role) {
        TypedQuery<Role> userTypedQuery = entityManager.createQuery("select  r from Role r where r.role =:role", Role.class);
        userTypedQuery.setParameter("role", role);
        return userTypedQuery.getResultList().stream().findAny().orElse(null);
    }
}
