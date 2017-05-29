package rab;

import model.Admin;
import model.DB;

public class Main {

    public static void main(String[] args) {

        Admin admin = DB.login("dren", "123123");
        
        admin.setPassword("123123");
    }
}
