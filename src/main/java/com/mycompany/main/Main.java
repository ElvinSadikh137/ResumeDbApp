package com.mycompany.main;
import com.company.dao.inter.*;
public class Main {
    public static void main(String[] args)throws Exception{//loosely coupling //thightly couplin
       UserDaoInter dao = Context.instanceUserDao();
        System.out.println(dao.getUserById(1));
        

    }
}

