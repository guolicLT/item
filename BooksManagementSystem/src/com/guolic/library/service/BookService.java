package com.guolic.library.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import com.guolic.library.emtity.Book;
import com.guolic.library.emtity.BookVO;


public interface BookService {
    void addOneBook(Book book)  throws FileNotFoundException, Exception;
    List<BookVO> queryAllBooksByTypeId(String typeId) throws Exception;
}
