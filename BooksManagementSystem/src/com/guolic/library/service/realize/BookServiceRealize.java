package com.guolic.library.service.realize;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import com.guolic.library.dao.BookDAO;
import com.guolic.library.dao.realize.BookDAORealize;
import com.guolic.library.emtity.Book;
import com.guolic.library.emtity.BookVO;
import com.guolic.library.service.BookService;

public class BookServiceRealize implements BookService{
    private BookDAO bookDAO = new BookDAORealize();
    @Override
    public void addOneBook(Book book) throws FileNotFoundException, Exception {
        // TODO Auto-generated method stub
        bookDAO.addOne(book);
    }

    @Override
    public List<BookVO> queryAllBooksByTypeId(String typeId) throws Exception {
      
        return  bookDAO.queryAllByType(typeId);
    }



}
