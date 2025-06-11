package database;


import entity.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private static DataBase instance;

    private DataBase(){

    }

    public static DataBase getInstance()
    {
        if(instance == null)
        {
            instance = new DataBase();
        }
        return instance;
    }

    private Map<Class<? extends Entity>, DataBaseTable<? extends Entity>> tabelas = new HashMap<>();

    public <T extends Entity> void save(Class<T> classe, T entity){
        if (!tabelas.containsKey(classe)) {
            tabelas.put(classe, new DataBaseTable<T>());
        }

        ((DataBaseTable<T>) tabelas.get(classe)).save(entity);
    }

    public <T extends Entity> Collection<T> findAll(Class<T> classe)
    {

            if (!tabelas.containsKey(classe)) {
                tabelas.put(classe, new DataBaseTable<T>());
            }

            return ((DataBaseTable<T>) tabelas.get(classe)).findAll();
    }

    public <T extends Entity> void update(Class<T> classe, int id, T entity){

        if (!tabelas.containsKey(classe)) {
            tabelas.put(classe, new DataBaseTable<T>());
        }

        ((DataBaseTable<T>) tabelas.get(classe)).update(id, entity);
    }

    public <T extends Entity> void delete(Class<T> classe, int id) {

        if (!tabelas.containsKey(classe)) {
            tabelas.put(classe, new DataBaseTable<T>());
        }

        ((DataBaseTable<T>) tabelas.get(classe)).delete(id);
    }

}
