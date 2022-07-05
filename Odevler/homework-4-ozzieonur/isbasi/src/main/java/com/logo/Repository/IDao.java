package com.logo.Repository;

import java.util.List;

public interface IDao<T,Integer> {

    T save(T t);
    List<T> findAll();
    T findById(int id);
    T update (int id, T t);
    String deleteById(int id);


}
