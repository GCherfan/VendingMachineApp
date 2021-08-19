package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.AccountInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;

@Component
public class JdbcAccountDAO implements AccountDAO{

    private JdbcTemplate jdbcTemplate;

    //constructor
    public JdbcAccountDAO(DataSource ds){
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public BigDecimal getBalance(int userId) {
        AccountInfo currentBalance = new AccountInfo();
        String sql = "SELECT balance FROM accounts WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,userId);

        if(result.next()){
        currentBalance = mapRowToBalance(result);
        }
        return currentBalance.getBalance();
    }

    // HELPER METHOD
    private AccountInfo mapRowToBalance(SqlRowSet results){
        AccountInfo userAccount = new AccountInfo();
        userAccount.setBalance(results.getBigDecimal("balance"));
        userAccount.setUserId(results.getInt("user_id"));
        return userAccount;
    }
}
