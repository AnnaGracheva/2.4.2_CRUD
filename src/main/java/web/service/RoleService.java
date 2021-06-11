package web.service;

import web.model.Role;

import java.util.Set;

public interface RoleService {
    public Set<Role> loadRoleFromDB(Set<Role> roles);
}
