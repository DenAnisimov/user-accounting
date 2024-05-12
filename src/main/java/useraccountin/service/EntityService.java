package useraccountin.service;

import java.util.List;

public interface EntityService<T> {
    void add(T entity);
    void delete(T entity);
    T get(int id);
    List<T> getAll();
}
