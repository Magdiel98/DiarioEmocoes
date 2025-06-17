package database;

import java.util.Collection;
import java.util.Optional;

public interface DatabaseTableI<T extends Entity>{
    void save(T entity); //Criar DatabaseException depois
    Optional<T> findById(int id);
    Collection<T> findAll();
    void update(int id, T entity);
    void delete(int id);
}