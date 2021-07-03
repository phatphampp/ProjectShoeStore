/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.OrderDetailModel;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ACER
 */
public class OrderDetailRowMapper implements RowMapper<OrderDetailModel>{

    @Override
    public OrderDetailModel mapRow(ResultSet rs, int i) throws SQLException {
        OrderDetailModel od = new OrderDetailModel();
        od.setOrderId(rs.getInt("orderId"));
        od.setProductId(rs.getInt("productId"));
        od.setAmount(rs.getInt("amount"));
        od.setPrice(rs.getInt("price"));
        od.setQuantity(rs.getInt("quantity"));
        return od;
    }
    
}
