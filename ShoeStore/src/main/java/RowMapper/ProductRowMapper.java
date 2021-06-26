/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.ProductModel;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ASUS
 */
public class ProductRowMapper implements RowMapper<ProductModel> {
    @Override
    public ProductModel mapRow(ResultSet rs, int i) throws SQLException {
        ProductModel prod = new ProductModel();
        
        prod.setId(rs.getInt("id"));
        prod.setProdName(rs.getString("prodName"));
        prod.setDescription(rs.getString("description"));
        prod.setPrice(rs.getInt("price"));
        prod.setImage(rs.getString("image"));
        
        return prod;
    }
}
