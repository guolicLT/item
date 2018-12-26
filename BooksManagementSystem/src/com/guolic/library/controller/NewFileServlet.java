package com.guolic.library.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.guolic.library.controller.base.AbstractBaseServlet;
import com.guolic.library.emtity.Type;
import com.guolic.library.service.TypeService;
import com.guolic.library.service.realize.TypeServiceRealize;
@WebServlet("/NewFile")
public class NewFileServlet extends AbstractBaseServlet{
    private TypeService typeService = new TypeServiceRealize();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return null;
    }
    

   public String toHome(HttpServletRequest req, HttpServletResponse resp) throws Exception {
     //查询所有的图书类型列表
       List<Type> types = typeService.queryAllTypes();
       req.setAttribute("types", types);
       return "f:visitors";
       
   }


}
