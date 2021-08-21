package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Transfers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;

@Component
public class JdbcTransferDAO implements TransferDAO {

    private JdbcTemplate jdbcTemplate;
    private AccountDAO accountDAO;

    //constructor
    public JdbcTransferDAO(JdbcTemplate jdbcTemplate, AccountDAO accountDAO){
        this.jdbcTemplate = jdbcTemplate;
        this.accountDAO = accountDAO;
    }


    @Override
    public void userTransfers(Transfers transfers){

        System.out.println("ANDY DEBUG ******");
        System.out.println("AccountTo:" + transfers.getAccountTo());
        System.out.println("AccountFROM:" + transfers.getAccountFrom());

        // call the method that we defined underneath twice to get the correct
        // to and from account id's

        int accountFrom = getAccountIdFromUserId(transfers.getAccountFrom());
        int accountTo = getAccountIdFromUserId(transfers.getAccountTo());

        String sql = "INSERT INTO transfers " +
                "(transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "VALUES (1, 1, ?, ?, ?)";
        jdbcTemplate.update(sql, accountFrom, accountTo, transfers.getTransferAmount());

        //UPDATE ACCOUNT TO
        String sqlAccountTo = "UPDATE accounts SET balance = ? WHERE account_id = ?";

        //UPDATE ACCOUNT FROM
        String sqlAccountFrom = "UPDATE accounts SET balance = ? WHERE account_id = ?";


       int newBalance = accountDAO.getBalance(accountFrom) - transfers.getTransferAmount()

    }

    public int getAccountIdFromUserId (int userId) {

        // 1. make a sql that retrieves the account id given the user id;
        String sql = "select account_id from accounts where user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);

        int accountId = -1;

        if (result.next()) {
            accountId = result.getInt("account_id");
        }

        return accountId;

    }

    //HELPER METHOD
    private Transfers mapRowToTransfers(SqlRowSet rowSet){
        Transfers transfers = new Transfers(
                //rowSet.getInt("transfer_id"),
                //rowSet.getInt("transfer_type_id"),
                //rowSet.getInt("transfer_status_id"),
                rowSet.getInt("account_from"),
                rowSet.getInt("account_to"),
                rowSet.getBigDecimal("amount")
        );
        return transfers;
    }

}
