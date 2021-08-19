package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.AuthorizedUsers;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAuthorizedUsersDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcAuthorizedUsersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //@Override
    public List<AuthorizedUsers> listAll(){
        List<AuthorizedUsers> userList = new ArrayList<AuthorizedUsers>();
        String sql = "SELECT user_id, username FROM users";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()){
            userList.add(mapRowToUser(result));
        }

        return userList;
    }

    //HELPER METHOD
    private AuthorizedUsers mapRowToUser(SqlRowSet rowSet){
        AuthorizedUsers authorizedUsers = new AuthorizedUsers();
        authorizedUsers.setUsername(rowSet.getString("username"));
        authorizedUsers.setUserId(rowSet.getInt("user_id"));
        return authorizedUsers;
    }
}
