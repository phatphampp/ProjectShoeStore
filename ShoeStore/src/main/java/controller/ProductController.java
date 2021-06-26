/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ASUS
 */
@Controller
public class ProductController {
    @Autowired
    ProductDao dao;
    
    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public ModelAndView getAll(HttpServletRequest request){
        String keyword = request.getParameter("keyword");        
        List<ProductModel> lst;
        if (keyword == null || keyword == "") {
            lst = dao.getAll();
        } else {
            lst = dao.search(keyword);
        }
        return new ModelAndView("productview", "list",lst);
    }
}
