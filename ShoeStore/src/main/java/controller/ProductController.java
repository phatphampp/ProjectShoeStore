/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.AccountModel;
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
        ModelAndView mav = new ModelAndView();
        mav.setViewName("productview");
        
        mav.addObject("list", lst);
        
        AccountModel acc = Utils.Utils.getAccountInSession();
        if (acc != null) {
            mav.addObject("acc", acc);
        }
        
        return mav;
    }
    
    @RequestMapping(value = "/product/detail", method = RequestMethod.GET)
    public ModelAndView productDetail_view(HttpServletRequest request){
        int prodId = Integer.parseInt(request.getParameter("prodId"));        
        ProductModel prod = dao.getById(prodId);
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("productdetailview");
        
        mav.addObject("prod", prod);
        
        AccountModel acc = Utils.Utils.getAccountInSession();
        if (acc != null) {
            mav.addObject("acc", acc);
        }
        
        return mav;
    }
}
