package web.service;

import web.model.Role;

public interface RoleService {
    Role loadRoleFromDB(String role);
}
