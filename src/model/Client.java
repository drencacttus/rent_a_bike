package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {
    
    private int id;
    private String personalNumber;
    private int bikeId;
    private long leaseTime;
    private long returnTime;
    private float price;
    
    public int getId() {
        return id;
    }
    
    public String getPersonalNumber() {
        return personalNumber;
    }

    public int getBikeId() {
        return bikeId;
    }

    public long getLeaseTime() {
        return leaseTime;
    }

    public long getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(long returnTime) {
        
        this.returnTime = returnTime;
        updateDB();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        
        this.price = price;
        updateDB();
    }
    
    private void updateDB() {
    
        try {
        
            Connection sqlConn = DB.getConnection();
            Statement stmt = sqlConn.createStatement();
            stmt.executeUpdate("UPDATE klenti SET koha_pranimit=" + 
                                returnTime + 
                                ", pagesa=" + 
                                price + 
                                " WHERE id=" + 
                                id);
            
            stmt.close();
            sqlConn.close();
        }
        catch(SQLException ex) {
        
        }
    }
}
