package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Transfers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDAO implements TransferDAO {

    private JdbcTemplate jdbcTemplate;
    private AccountDAO accountDAO;

    //CONSTRUCTOR
    public JdbcTransferDAO(JdbcTemplate jdbcTemplate, AccountDAO accountDAO){
        this.jdbcTemplate = jdbcTemplate;
        this.accountDAO = accountDAO;
    }


    @Override
    public void userTransfers(Transfers transfers){

        //CALL HELPER METHOD TWICE TO GET CORRECT TO AND FROM ACCOUNT IDS
        int accountFrom = getAccountIdFromUserId(transfers.getAccountFrom());
        int accountTo = getAccountIdFromUserId(transfers.getAccountTo());

        //CREATE TRANSFER
        String sql = "INSERT INTO transfers " +
                "(transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "VALUES (1, 1, ?, ?, ?)";
        jdbcTemplate.update(sql, accountFrom, accountTo, transfers.getTransferAmount());

        //UPDATE ACCOUNT TO
        //String sqlAccountTo = "UPDATE accounts SET balance = ? WHERE account_id = ?";
        accountDAO.addToBalance(transfers.getTransferAmount(), accountTo);
        //UPDATE ACCOUNT FROM
        //String sqlAccountFrom = "UPDATE accounts SET balance = ? WHERE account_id = ?";
        accountDAO.subtractFromBalance(transfers.getTransferAmount(), accountFrom);

    }

    @Override
    public List<Transfers> seeTransferHistory() {
        List<Transfers> transferHistory = new ArrayList<Transfers>();
        String sql = "SELECT * FROM transfers";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            //Transfers transfers = mapRowToTransfers(result);
            transferHistory.add(mapRowToTransfers(result));
        }
            return transferHistory;
    }



    //HELPER METHODS
    public int getAccountIdFromUserId (int userId) {
        //SQL STATEMENT THAT RETRIEVE ACCOUNT ID GIVEN USER ID
        String sql = "SELECT account_id FROM accounts WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);

        int accountId = -1; //create accountId that will never be true
        if (result.next()) {
            accountId = result.getInt("account_id");
        }
        return accountId;
    }

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
