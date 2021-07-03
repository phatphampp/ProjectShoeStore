/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.OrderModel;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ACER
 */
public class OrderRowMapper implements RowMapper<OrderModel>{

    @Override
    public OrderModel mapRow(ResultSet rs, int i) throws SQLException {
        OrderModel od = new OrderModel();
        od.setId(rs.getInt("id"));
        od.setAmount(rs.getDouble("amount"));
        od.setCusId(rs.getInt("customerId"));
        return od;
    }
    
}
