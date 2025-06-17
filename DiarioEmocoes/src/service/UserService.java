package service;

import dao.UserDAO;
import entity.User;

import java.util.Optional;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public boolean register(String username, String password)
    {
        if(userDAO.findByUsername(username).isPresent()) return false;
        userDAO.save(new User(username, password));
        return true;
    }

    public Optional<User> login(String username, String passowrd)
    {
        return userDAO.findByUsername(username)
                .filter(u -> u.getPassword().equals(passowrd));
    }
}
