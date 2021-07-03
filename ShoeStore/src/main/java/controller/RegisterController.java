/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDao;
import javax.servlet.http.HttpServletRequest;
import model.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ASUS
 */
@Controller
public class RegisterController {
    @Autowired
    AccountDao dao;
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getAll(HttpServletRequest request){
        return new ModelAndView("registerview");
    }
    
    @RequestMapping(value = "/register/save",method = RequestMethod.POST)
    public ModelAndView Add(AccountModel acc){
        boolean res = dao.insert(acc);
        if (res) {
            return new ModelAndView("successfulview", "title", "Register");
        }else{
            return new ModelAndView("errorview", "title", "Register");
        }
        
    }
}
