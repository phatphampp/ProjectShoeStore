/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class CartInfo {
    private List<CartItem> cart = new ArrayList<CartItem>();
    private OrderModel order;

    public OrderModel getOrder() {
        order = new OrderModel();
        order.setAmount(amountCart());
        return order;
    }
    public void removeCart(){
        cart = new ArrayList<CartItem>();
    }
    private double amountCart(){
        double amount = 0;
        for (CartItem item : cart) {
            amount += item.getAmount();
        }
        return amount;
    }

    public List<CartItem> getCart() {
        return cart;
    }
    public void addToCart(CartItem od){
        boolean added = false;
        for (CartItem item : cart) {
            if (item.getProductId() == od.getProductId()) {
                item.setQuantity(item.getQuantity() + 1);
                item.setAmount(item.getQuantity() * item.getPrice());
                added = true;
            }
        }
        if (!added) {
            od.setQuantity(1);
            od.setAmount(od.getQuantity() * od.getPrice());
            cart.add(od);
        }
    }

    public void setOrderId(int lastIndex) {
        for (CartItem item : cart) {
            item.setOrderId(lastIndex);
        }
    }
}
