package database;

import entity.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataBaseTable <T extends Entity> implements DatabaseTableI<T>{

    private Map<Integer, T> elementos = new HashMap<>();

    private int identidade = 0; //Atributo do tipo inteiro que deve ser incrementado e usado como id de novas entidades durante
    //uma inserção

    @Override
    public void save(T entity){
        entity.setId(++identidade);
        elementos.put(entity.getId(), entity);
    }

    @Override
    public Optional<T> findById(int id){
        return null;
    }

    @Override
    public Collection<T> findAll(){
        return elementos.values();
    }

    @Override
    public void update(int id, T entity)
    {
        elementos.replace(id, entity);
    }

    @Override
    public void delete(int id){

        elementos.remove(id);
    }
}
