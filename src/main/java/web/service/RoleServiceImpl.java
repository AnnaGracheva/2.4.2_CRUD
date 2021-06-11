package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import web.dao.RoleDao;
import web.model.Role;

@Service
//@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public Role loadRoleFromDB(String role) {
        return roleDao.getRole(role);
    }
}
