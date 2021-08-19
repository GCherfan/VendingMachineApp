package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.AuthorizedUsers;
import com.techelevator.tenmo.model.User;

import java.util.List;

public interface AuthorizedUsersDAO {

    List<AuthorizedUsers> listAll();
}
