package com.aop.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements  MembershipDAO {

    @Override
    public void addMember() {
        System.out.println(getClass().getSimpleName() + " : Adding a membership account");
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass().getSimpleName() + " : Going to sleep");
    }
}
