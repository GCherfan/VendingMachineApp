package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.TransferDAO;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.AuthorizedUsers;
import com.techelevator.tenmo.model.Transfers;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")

public class TenmoController {

    @Autowired
    AccountDAO accountDAO;
    @Autowired
    UserDao userDao;
    @Autowired
    TransferDAO transferDAO;

    //GET BALANCE
    @RequestMapping(path="/balance", method = RequestMethod.GET)
    public BigDecimal getBalance(Principal user){
        int userId = userDao.findIdByUsername(user.getName());
        return accountDAO.getBalance(userId).getBalance();
    }

    //LIST OF USERS TO TRANSFER
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> listAll(){
        List<User> userList = new ArrayList<>();
        userList = userDao.findAll();
        return userList;
    }

    //TRANSFERS
    @RequestMapping(path = "/transfers", method = RequestMethod.POST)
    public void userTransfers(@RequestBody Transfers transfers){
        transferDAO.userTransfers(transfers);
    }

    @RequestMapping(path = "/transfers/history", method = RequestMethod.GET)
    public List<Transfers> seeTransferHistory(){
        List<Transfers> transfersList = new ArrayList<>();
        transfersList = transferDAO.seeTransferHistory();
        return transfersList;
    }

}
