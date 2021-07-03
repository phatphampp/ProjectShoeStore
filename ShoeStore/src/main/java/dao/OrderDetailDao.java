/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CartItem;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ACER
 */
public class OrderDetailDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int insertCart(List<CartItem> cart) {
        StringBuilder sb = new StringBuilder("insert into OrderDetail (orderId, productId,amount,price,quantity) values");
        for (CartItem item : cart) {
            String value = String.format(" (%d, %d, %d, %d, %d),", 
                    item.getOrderId(), item.getProductId(), item.getAmount(), item.getPrice(), item.getQuantity());
            sb.append(value);
        }
        sb.deleteCharAt(sb.length() - 1);
        return template.update(sb.toString());
    }
}
