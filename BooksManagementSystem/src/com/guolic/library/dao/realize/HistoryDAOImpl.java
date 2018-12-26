package com.guolic.library.dao.realize;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.guolic.library.dao.HistoryDAO;
import com.guolic.library.emtity.History;
import com.guolic.library.util.JDBCUtil;

public class HistoryDAOImpl implements HistoryDAO {

    @Override
    public void addOne(History history) throws SQLException {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into history (id,bid,uid,borrow_time,return_time) values(?,?,?,?,?)";
        runner.update(sql, history.getId(),history.getBid(),history.getUid(),history.getBorrow_time(),history.getReturn_time());
    }

    @Override
    public List<History> queryAllHistoryByUid(String uid) throws SQLException {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        String sql ="select * from history where uid =?";
        List<History> historys = runner.query(sql, new BeanListHandler<History>(History.class),uid);
        return historys;
    }

    @Override
    public void updateReturnTime(String id, String returnTime) throws SQLException {
        QueryRunner runner=new QueryRunner();
        Connection connection = JDBCUtil.getConnection();
        String sql ="update history set return_time = ? where id =?";
        runner.update(connection, sql, returnTime,id);
    }

}
