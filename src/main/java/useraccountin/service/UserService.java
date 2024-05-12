package useraccountin.service;

import useraccountin.model.User;

public interface UserService extends EntityService<User> {
    void update(User entity, String password);
}
