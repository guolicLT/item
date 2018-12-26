package com.guolic.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guolic.library.controller.base.AbstractBaseServlet;
import com.guolic.library.emtity.Book;
import com.guolic.library.emtity.BookVO;
import com.guolic.library.service.BookService;
import com.guolic.library.service.realize.BookServiceRealize;

@WebServlet("/book.do")
public class BookServlet extends AbstractBaseServlet {
    private BookService bookService = new BookServiceRealize();

    public String queryAllBooksByType(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String typeId = req.getParameter("typeId");
        List<BookVO> books = bookService.queryAllBooksByTypeId(typeId);
        req.setAttribute("books", books);
        return "f:booksByType";
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        return null;
    
    
    }
}
