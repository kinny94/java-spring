package com.aop.demo.dao;

import com.aop.demo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements  AccountDAO {

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println("Getting account name: " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("Setting account name: " + name);
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("Getting account service code: " + serviceCode);
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("Setting account service code: " + serviceCode);
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // simulate an exception

        if (tripWire) {
            throw new RuntimeException("Runtime exception...");
        }
        List<Account> myAccounts = new ArrayList<>();
        Account account = new Account("John", "Silver");
        Account account1 = new Account("Jane", "Gold");
        Account account2 = new Account("Jack", "Silver");
        myAccounts.add(account);
        myAccounts.add(account1);
        myAccounts.add(account2);
        return myAccounts;
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass().getSimpleName() + ": Doing my db work: Adding an account!");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass().getSimpleName() + ": Doing my work!");
        return false;
    }
}
