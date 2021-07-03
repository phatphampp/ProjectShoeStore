/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDao;
import javax.servlet.http.HttpServletRequest;
import model.AccountModel;
import model.LoginModel;
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
public class LoginController {
    @Autowired
    AccountDao dao;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getAll(HttpServletRequest request){
        return new ModelAndView("loginview");
    }
    
    @RequestMapping(value = "/login/fail", method = RequestMethod.GET)
    public ModelAndView loginfail(HttpServletRequest request){
        return new ModelAndView("errorview", "title","Login");
    }
    
    @RequestMapping(value = "/login/handle", method = RequestMethod.POST)
    public String login(LoginModel lm){
        AccountModel acc = dao.getAccount(lm.getUsername(), lm.getPassword());
        
        if (acc != null) {
            Utils.Utils.setAccountInSession(acc);
            return "redirect:/product/list.html";
        }
        return "redirect:/login/fail.html";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        Utils.Utils.removeAccountInSession();
        return "redirect:/login.html";
    }
}
