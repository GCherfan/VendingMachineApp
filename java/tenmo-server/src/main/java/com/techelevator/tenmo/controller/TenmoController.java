package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.AccountInfo;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")

public class TenmoController {

    @Autowired
    AccountDAO accountDAO;
    @Autowired
    UserDao userDao;

    @RequestMapping(path="/balance", method = RequestMethod.GET)
    public BigDecimal getBalance(Principal user){
        int userId = userDao.findIdByUsername(user.getName());
        return accountDAO.getBalance(userId).getBalance();
    }

}
