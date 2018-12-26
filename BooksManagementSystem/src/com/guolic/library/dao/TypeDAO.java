package com.guolic.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.guolic.library.emtity.Type;

public interface TypeDAO{
    void addOne(Type type) throws Exception;
    public List<Type> queryAll()  throws Exception ;
}
