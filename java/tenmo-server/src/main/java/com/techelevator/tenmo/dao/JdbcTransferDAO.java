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

    //constructor
    public JdbcTransferDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void userTransfers(Transfers transfers){
        String sql = "INSERT INTO transfers " +
                "(transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "VALUES (1, 1, ?, ?, ?)";
        jdbcTemplate.update(sql, transfers.getAccountFrom(),
                transfers.getAccountTo(), transfers.getTransferAmount());

        /*UPDATE accounts
            SET balance = ?
            WHERE account_id = ? */

    }

    //HELPER METHOD
    private Transfers mapRowToTransfers(SqlRowSet rowSet){
        Transfers transfers = new Transfers(
                rowSet.getLong("transfer_id"),
                rowSet.getLong("transfer_type_id"),
                rowSet.getLong("transfer_status_id"),
                rowSet.getLong("account_from"),
                rowSet.getLong("account_to"),
                rowSet.getBigDecimal("amount")
        );
        return transfers;
    }

}
