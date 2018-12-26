package com.guolic.library.service;

import java.sql.SQLException;
import java.util.List;

import com.guolic.library.emtity.Type;


public interface TypeService {
    public void addOneType(Type type) throws Exception;
    
    public List<Type> queryAllTypes()  throws Exception;
}
