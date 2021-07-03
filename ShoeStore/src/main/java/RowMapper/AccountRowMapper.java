/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.AccountModel;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ACER
 */
public class AccountRowMapper implements RowMapper<AccountModel> {
    @Override
    public AccountModel mapRow(ResultSet rs, int i) throws SQLException {
        AccountModel acc = new AccountModel();
        
        acc.setId(rs.getInt("id"));
        acc.setUsername(rs.getString("username"));
        acc.setPassword(rs.getString("password"));
        acc.setAddress(rs.getString("address"));
        acc.setEmail(rs.getString("email"));
        acc.setName(rs.getString("name"));
        acc.setPhone(rs.getString("phone"));
        
        return acc;
    }
}
