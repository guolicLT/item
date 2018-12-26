package com.guolic.library.service.realize;

import java.sql.SQLException;
import java.util.List;

import com.guolic.library.dao.BookDAO;
import com.guolic.library.dao.TypeDAO;
import com.guolic.library.dao.realize.BookDAORealize;
import com.guolic.library.dao.realize.TypeDAORealize;
import com.guolic.library.emtity.Type;
import com.guolic.library.service.TypeService;

public class TypeServiceRealize implements TypeService{
     private TypeDAO typeDAO = new TypeDAORealize();
             
    @Override
    public void addOneType(Type type) throws Exception {
        typeDAO.addOne(type);
    }

    @Override
    public List<Type> queryAllTypes() throws Exception {
       
        return typeDAO.queryAll();
    }


}
