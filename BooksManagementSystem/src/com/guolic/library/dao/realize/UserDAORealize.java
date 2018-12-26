package com.guolic.library.dao.realize;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.guolic.library.dao.UserDAO;
import com.guolic.library.emtity.History;
import com.guolic.library.emtity.User;
import com.guolic.library.util.JDBCUtil;

public class UserDAORealize implements UserDAO {


    @Override
    public void addOne(User user) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into user(id,account,password) values(?,?,?)";
        queryRunner.update(sql,user.getId(),user.getAccount(),user.getPassword());
    }

    @Override
    public User queryOneUserByAccount(String name) throws SQLException {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        String sql="select * from user where account=?";
        User user = runner.query(sql, new BeanHandler<User>(User.class),name);
        return user;
    }

    @Override
    public User queryOneByAccountAndPassword(String name, String password) throws SQLException {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        String sql="select * from user where account=? and password=?";
        User user = runner.query(sql, new BeanHandler<User>(User.class),name,password);
        return user;
    }

    @Override
    public void removeOneUserByAccountAndPassword(String account, String password) throws Exception {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from user where account=? and password=?";
        runner.update(sql, account,password);
    }
}
