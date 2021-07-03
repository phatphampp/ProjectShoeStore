/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import RowMapper.OrderRowMapper;
import model.OrderModel;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ACER
 */
public class OrderDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int getLastIndex(){
        String query = "SELECT * FROM orders ORDER BY id DESC LIMIT 1";
        OrderModel od = template.queryForObject(query,  new OrderRowMapper());
        return od.getId();
    }
    public boolean insert(OrderModel order) {
        String sql = String.format("insert into Orders (amount,customerId) values(%f,%d)", 
                order.getAmount(),order.getCusId());
        if (template.update(sql) > 0) {
            return true;
        }        
        return false;
    }
}
