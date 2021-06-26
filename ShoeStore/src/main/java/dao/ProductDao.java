/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import RowMapper.ProductRowMapper;
import java.util.List;
import model.ProductModel;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ASUS
 */
public class ProductDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    public List<ProductModel> getAll() {
        return template.query("select * from Product", new ProductRowMapper());
    }
    
    public List<ProductModel> search(String keyword){
        String query = "select * from Product where prodName LIKE '%" + keyword + "%'";
        return template.query(query, new ProductRowMapper());
    }
}
