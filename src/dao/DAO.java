package dao;


import entity.Entity;

import java.util.Collection;

public interface DAO<T extends Entity>{
    void save(T entity);
    Collection<T> findAll();
    void update(int id, T entity);
    void delete(int id);
}
