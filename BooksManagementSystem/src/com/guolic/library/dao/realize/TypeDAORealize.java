package com.guolic.library.dao.realize;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.guolic.library.dao.TypeDAO;
import com.guolic.library.emtity.Type;
import com.guolic.library.util.JDBCUtil;

public class TypeDAORealize implements TypeDAO{


    @Override
    public void addOne(Type type) throws Exception {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        String sql="insert into type(id,type,img) values(?,?,?)";
        runner.update(sql, type.getId(),type.getType(),type.getImg());
        
    }

    @Override
    public List<Type> queryAll() throws Exception {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from type";
        List<Type> types = runner.query(sql, new BeanListHandler<Type>(Type.class));
        return types;
    }

}
