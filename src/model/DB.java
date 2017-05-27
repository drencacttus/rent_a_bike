package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
   
    public static String connString = "jdbc:sqlserver://DESKTOP-75DNHP5;databaseName=rent_a_bike;integratedSecurity=true";
    
    public static Connection getConnection() throws SQLException {
    
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            return DriverManager.getConnection(connString);
        }
        catch(ClassNotFoundException ex) {
        
            return null;
        }
    }
    
    public static Admin login(String username, String password) {
    
        Admin result = null;
        
        try {
        
            Connection sqlConn = DB.getConnection();
            Statement stmt = sqlConn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM admin WHERE username='" + username + "'");
            
            rs.next();
            
            if(rs.getRow() != 0) {
            
                String dbPasswordHash = rs.getString("password");
                String dbSalt = rs.getString("salt");
                
                String typedPasswordHash = Helpers.getPasswordHash(password + dbSalt);
                
                if(typedPasswordHash.equals(dbPasswordHash)) {
                
                    result = new Admin(rs);
                }
                else {
                
                    //invalid password
                }
            }
            else {
            
                //invalid username
            }
            
            rs.close();
            stmt.close();
            sqlConn.close();
        }
        catch(SQLException ex) {
        
            //DB error
        }
        
        return result;
    } 
    
    public static ArrayList<BikeType> getBikeTypes() {
    
        ArrayList<BikeType> result = new ArrayList<>();
        
        try {
        
            Connection sqlConn = DB.getConnection();
            Statement stmt = sqlConn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bicikleta_llojet");
            
            while(rs.next()) {
        
                result.add(new BikeType(rs));
            }
            
            rs.close();
            stmt.close();
            sqlConn.close();
        }
        catch(SQLException ex) {
        
            //DB error
        }
        
        return result;
    }
}
