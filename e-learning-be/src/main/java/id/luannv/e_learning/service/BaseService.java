package id.luannv.e_learning.service;

import java.util.List;

public interface BaseService<T, UID> {
    List<T> getAll();
    T getById(UID id);
    T create(T t);
    T update(T t);
    void delete(UID id);
}
