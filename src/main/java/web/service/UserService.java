package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public void updateUser(User user);
    public User userById(Long id);
    public void deleteUser(Long id);
    public List<User> listOfUsers();
}
