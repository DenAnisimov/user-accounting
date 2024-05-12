package useraccountin.service;

import useraccountin.model.Role;

public interface RoleService extends EntityService<Role> {
    void update(Role entity, String name);
}
