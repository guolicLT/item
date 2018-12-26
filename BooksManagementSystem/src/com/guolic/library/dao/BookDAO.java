package com.guolic.library.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.guolic.library.emtity.Book;
import com.guolic.library.emtity.BookVO;
import com.guolic.library.emtity.Type;

public interface BookDAO  {
    void addOne(Book book)throws FileNotFoundException, Exception ;
    List<BookVO> queryAllByType(String typeId)throws FileNotFoundException, Exception ;
    void updateIsBorrowByBookId(String Bid, String isBorrowed) throws SQLException;
}
