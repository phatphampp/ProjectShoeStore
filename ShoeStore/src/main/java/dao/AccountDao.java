/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import RowMapper.AccountRowMapper;
import Utils.Utils;
import model.AccountModel;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ACER
 */
public class AccountDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public AccountModel getAccount(String username, String password){
        try {
            password = Utils.MD5(password);
            String sql = String.format("select * from Account where username='%s' and password='%s'", username, password);
            return template.queryForObject(sql, new AccountRowMapper());
        } catch (Exception e) {
            return null;
        }
    }
    public boolean insert(AccountModel acc){
        acc.setPassword(Utils.MD5(acc.getPassword()));
        String sql = String.format("insert into Account (username,password,address,email,name,phone) values('%s','%s','%s','%s','%s','%s')", 
                acc.getUsername(), acc.getPassword(), acc.getAddress(), acc.getEmail(), acc.getName(), acc.getPhone());
        if (template.update(sql) > 0) {
            return true;
        }        
        return false;
    }
}
