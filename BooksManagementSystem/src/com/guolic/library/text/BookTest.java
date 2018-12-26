package com.guolic.library.text;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import com.guolic.library.dao.BookDAO;
import com.guolic.library.dao.realize.BookDAORealize;
import com.guolic.library.emtity.Book;
import com.guolic.library.emtity.BookVO;
import com.guolic.library.util.UUIDUtil;
public class BookTest {

    @Test
    public void addBook() throws FileNotFoundException, Exception {
        BookDAO bookDAO = new BookDAORealize();
        Book book = new Book();
        book.setId(UUIDUtil.generateUUID());
        book.setName("人工智能時代");
        book.setWriter("王小川");
        book.setImg("");
        bookDAO.addOne(book);
        System.out.println("添加成功");
    }

    @Test
    public void testQueryAllByType() throws FileNotFoundException, Exception {
        BookDAO dao=new BookDAORealize();
        List<BookVO> books = dao.queryAllByType("d4aef157c5cb45f6a2e7d3476a2ea9eb");
        System.out.println(books);
    }
    
    
    public void testQueryAllType() {
    }
}
