package rab;

import java.sql.SQLException;
import model.Admin;
import model.DB;

public class Main {

    public static void main(String[] args) {

        Admin admin = DB.login("dren", "123123");
        
        try {
            
            admin.setPassword("123123");
        } 
        catch (SQLException ex) {
            
            //Connection error
        }
    }
}
