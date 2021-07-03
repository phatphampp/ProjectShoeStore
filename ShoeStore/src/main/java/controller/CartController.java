/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDao;
import dao.OrderDetailDao;
import dao.ProductDao;
import model.OrderDetailModel;
import javax.servlet.http.HttpServletRequest;
import model.AccountModel;
import model.CartItem;
import model.OrderModel;
import model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ACER
 */
@Controller
public class CartController {
    @Autowired
    ProductDao dao;
    
    @Autowired
    OrderDao orderDao;
    
    @Autowired
    OrderDetailDao oddDao;
    
    @RequestMapping(value = "/cart.html", method = RequestMethod.GET)
    public ModelAndView getAll(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cartview");
        
        mav.addObject("list", Utils.Utils.CartInfoInSession.getCart());
        mav.addObject("total", Utils.Utils.CartInfoInSession.getOrder().getAmount());
        AccountModel acc = Utils.Utils.getAccountInSession();
        if (acc != null) {
            mav.addObject("acc", acc);
        }
        
        return mav;
    }
    
    @RequestMapping(value = "/cart/fail", method = RequestMethod.GET)
    public ModelAndView fail(HttpServletRequest request){
        return new ModelAndView("errorview", "title","Payment");
    }
    
    @RequestMapping(value = "/cart/successful", method = RequestMethod.GET)
    public ModelAndView successful(HttpServletRequest request){
        return new ModelAndView("successfulview", "title","Payment");
    }
    
    @RequestMapping(value = "/cart/add.html", method = RequestMethod.GET)
    public String add(@RequestParam("prodId") int prodId){
        ProductModel prod = dao.getById(prodId);
        CartItem od = new CartItem();
        od.setProdName(prod.getProdName());
        od.setPrice(prod.getPrice());
        od.setProductId(prod.getId());
        Utils.Utils.CartInfoInSession.addToCart(od);
        return "redirect:/product/list.html";
    }
    
    @RequestMapping(value = "/cart/payment.html", method = RequestMethod.GET)
    public String payment(HttpServletRequest request){
        if (Utils.Utils.getAccountInSession() == null) {
            return "redirect:/login.html";
        }
        if (Utils.Utils.CartInfoInSession.getCart().isEmpty()) {
            return "redirect:/cart/fail.html";
        }
        OrderModel od = Utils.Utils.CartInfoInSession.getOrder();
        od.setCusId(Utils.Utils.getAccountInSession().getId());
        
        orderDao.insert(od);
        Utils.Utils.CartInfoInSession.setOrderId(orderDao.getLastIndex());
        
        int res = oddDao.insertCart(Utils.Utils.CartInfoInSession.getCart());
        if (res > 0) {
            Utils.Utils.CartInfoInSession.removeCart();
            return "redirect:/cart/successful.html";
        }
        return "redirect:/cart/fail.html";
    }
}
