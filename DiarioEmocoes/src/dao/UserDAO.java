package dao;

import entity.User;
import java.util.*;

public class UserDAO implements DAO<User> {
    private Map<Integer, User> users = new HashMap<>();
    private int nextId = 1;

    @Override
    public void save(User user) {
        user.setId(nextId++);
        users.put(user.getId(), user);
    }

    @Override
    public Collection<User> findAll() {
        return users.values();
    }

    @Override
    public void update(int id, User user) {
        users.put(id, user);
    }

    @Override
    public void delete(int id) {
        users.remove(id);
    }

    public Optional<User> findByUsername(String username) {
        return users.values().stream().filter(u -> u.getUsername().equals(username)).findFirst();
    }
}
