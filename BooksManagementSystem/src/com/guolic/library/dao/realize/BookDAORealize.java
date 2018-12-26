package com.guolic.library.dao.realize;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.guolic.library.dao.BookDAO;
import com.guolic.library.emtity.Book;
import com.guolic.library.emtity.BookVO;
import com.guolic.library.util.JDBCUtil;

public class BookDAORealize implements BookDAO {

    /**
     * 添加一本
     * 
     * @throws Exception
     */
    @Override
    public void addOne(Book book) throws Exception {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into book(id,name,writer,img,isBorrowed) values(?,?,?,?,?)";
        runner.update(sql, book.getId(), book.getName(), book.getWriter(), book.getImg(), book.getIsBorrowed());
    }

    /**
     * 通过属性查询所有
     * 
     * @throws Exception
     */

    @Override
    public List<BookVO> queryAllByType(String typeId) throws FileNotFoundException, Exception {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * , t.id as typeId from type t,booktype bt,book b where  bt.tid = t.id and b.id = bt.bid and t.id=?";
        List<BookVO> books = runner.query(sql, new BeanListHandler<BookVO>(BookVO.class), typeId);
        return books;
    }
    @Override
//    将书信息更改为不可借状态
    public void updateIsBorrowByBookId(String Bid, String isBorrowed) throws SQLException {
        QueryRunner runner=new QueryRunner();
        Connection connection = JDBCUtil.getConnection();
        String sql = "update book set isBorrowed = ? where id=?";
        runner.update(connection, sql,isBorrowed,Bid);
    }
}
