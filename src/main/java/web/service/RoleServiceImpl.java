package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import web.dao.RoleDao;
import web.model.Role;

import java.util.HashSet;
import java.util.Set;

@Service
//@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public Set<Role> loadRoleFromDB(Set<Role> roles) {
        Set<Role> rolesFromDB = new HashSet<>();
        for (Role role : roles) {
            rolesFromDB.add(roleDao.getRole(role.toString()));
        }
        return rolesFromDB;
    }

}
