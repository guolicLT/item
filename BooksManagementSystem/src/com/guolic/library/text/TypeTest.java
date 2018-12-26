package com.guolic.library.text;

import java.util.List;

import org.junit.Test;

import com.guolic.library.dao.TypeDAO;
import com.guolic.library.dao.realize.TypeDAORealize;
import com.guolic.library.emtity.Type;
import com.guolic.library.util.UUIDUtil;

public class TypeTest {
    @Test
    public void addType() throws Exception {
        TypeDAO typeDAORealize = new TypeDAORealize();
        Type type = new Type();
        type.setId(UUIDUtil.generateUUID());
        type.setType("爱情");
        typeDAORealize.addOne(type);
    }
    @Test
    public void testQueryAllType() throws Exception {
        TypeDAO typeDAORealize = new TypeDAORealize();
        List<Type> queryAll = typeDAORealize.queryAll();
        System.out.println(queryAll);
    }
}
