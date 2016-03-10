package com.springapp.persist.dao;

/**
 * Created by guoqing on 2016/3/7 0007.
 */
public interface IBaseDao<T> {
    void add(T t);
    void delete(T t);
    void update(T t);
    void select(T t);
}
