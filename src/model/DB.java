package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
   
    private static final String HOSTNAME = "DESKTOP-75DNHP5";
    private static final String DATABASE = "rent_a_bike";
    
    public static final String CONNECTION_STRING = "jdbc:sqlserver://" + HOSTNAME + ";databaseName=" + DATABASE + ";integratedSecurity=true";
    
    public static Connection getConnection() throws SQLException {
    
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            return DriverManager.getConnection(CONNECTION_STRING);
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
    
    public static ArrayList<BikeType> getBikeTypes() throws SQLException {
    
        ArrayList<BikeType> result = new ArrayList<>();
        
        Connection sqlConn = DB.getConnection();
        Statement stmt = sqlConn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM bicikleta_llojet");

        while(rs.next()) {

            result.add(new BikeType(rs));
        }

        rs.close();
        stmt.close();
        sqlConn.close();

        
        return result;
    }
    
    public static ArrayList<Bike> getAllBikes() throws SQLException {
    
        ArrayList<Bike> result = new ArrayList<>();
        
        Connection sqlConn = DB.getConnection();
        Statement stmt = sqlConn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM bicikleta");

        while(rs.next()) {

            result.add(new Bike(rs));
        }

        rs.close();
        stmt.close();
        sqlConn.close();

        return result;
    }

    public static ArrayList<Bike> getFreeBikes() throws SQLException {
    
        ArrayList<Bike> result = new ArrayList<>();
        
        Connection sqlConn = DB.getConnection();
        Statement stmt = sqlConn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM bicikleta WHERE statusi=0");

        while(rs.next()) {

            result.add(new Bike(rs));
        }

        rs.close();
        stmt.close();
        sqlConn.close();

        return result;
    }
    
    public static ArrayList<Client> getClients() throws SQLException {
    
        ArrayList<Client> result = new ArrayList<>();
        
        Connection sqlConn = DB.getConnection();
        Statement stmt = sqlConn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM klienti");

        while(rs.next()) {

            result.add(new Client(rs));
        }

        rs.close();
        stmt.close();
        sqlConn.close();

        return result;
    }
    
    public static ArrayList<Client> searchClient(String personalNumber) throws SQLException {

        ArrayList<Client> result = new ArrayList<>();
        
        Connection sqlConn = DB.getConnection();
        Statement stmt = sqlConn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM klienti WHERE numri_personal='" + personalNumber + "'");

        while(rs.next()) {

            result.add(new Client(rs));
        }

        rs.close();
        stmt.close();
        sqlConn.close();

        return result;
    }
}
