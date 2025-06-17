package database;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Database instance;

    private Database()
    {

    }

    public static Database getInstance()
    {
        if(instance == null)
        {
            instance = new Database();
        }

        return instance;
    }


    private Map<Class<? extends Entity>, DatabaseTable<? extends Entity>> tabelas = new HashMap<>();

    public <T extends Entity> void save(Class<T> classe, T entity)
    {
            if (!tabelas.containsKey(classe)) {
                tabelas.put(classe, new DatabaseTable<T>());
            }

            ((DatabaseTable<T>) tabelas.get(classe)).save(entity);

    }

    public <T extends Entity> Collection<T> findAll(Class<T> classe) throws DatabaseException
    {

            if (!tabelas.containsKey(classe)) {
                tabelas.put(classe, new DatabaseTable<T>());
            }

            return ((DatabaseTable<T>) tabelas.get(classe)).findAll();


    }

    public <T extends Entity> void update(Class<T> classe, int id, T entity) throws DatabaseException
    {
        if (!tabelas.containsKey(classe)) {
            tabelas.put(classe, new DatabaseTable<T>());
        }

        ((DatabaseTable<T>) tabelas.get(classe)).update(id, entity);

    }

    public <T extends Entity> void delete(Class<T> classe, int id) throws DatabaseException
    {

        if (!tabelas.containsKey(classe)) {
            tabelas.put(classe, new DatabaseTable<T>());
        }

        ((DatabaseTable<T>) tabelas.get(classe)).delete(id);

    }
}
