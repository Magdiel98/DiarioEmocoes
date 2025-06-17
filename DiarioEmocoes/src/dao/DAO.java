package dao;


import entity.Entity;

import java.util.Collection;

public interface DAO<T extends Entity>{
    void save(T entity);
    //Optional<T> findById(int id);
    Collection<T> findAll();
    //List<T> findAll(Predicate<T> filter);
    //List<T> findAll(Comparator<T> comparator);
    void update(int id, T entity);
    void delete(int id);
}
