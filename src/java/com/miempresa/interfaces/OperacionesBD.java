package com.miempresa.interfaces;

import java.util.ArrayList;

/**
 *
 * @author BUJAICO PACHECO JERSON KEVIN
 */
public interface OperacionesBD <T> {
    
    public abstract Boolean insert(T t);
    public abstract Boolean update(T t);
    public abstract Boolean delete(Object id);
    public abstract ArrayList<T> selectAll();
    public abstract T selectById(Object idd);
    public abstract ArrayList<T> selectByName(String name);
    public abstract void closeConnection();
}
