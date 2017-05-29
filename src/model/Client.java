package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {
    
    private int id;
    private String personalNumber;
    private int bikeId;
    private int adminId;
    private long leaseTime;
    private long returnTime;
    private float price;
    
    public Client(ResultSet rs) throws SQLException {
    
        id = rs.getInt("id");
        personalNumber = rs.getString("numri_personal");
        bikeId = rs.getInt("bicikleta_id");
        adminId = rs.getInt("admin_id");
        leaseTime = rs.getLong("koha_dorezimit");
        returnTime = rs.getLong("koha_pranimit");
        price = rs.getFloat("pagesa");
    }
    
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

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    
    
    public long getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(long returnTime) throws SQLException {
        
        long tmpReturnTime = this.returnTime;
        
        try {
            
            this.returnTime = returnTime;
            updateDB();
        }
        catch(SQLException ex) {
        
            this.returnTime = tmpReturnTime;
            throw ex;
        }
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) throws SQLException {
        
        float tmpPrice = this.price;
        
        try {
            
            this.price = price;
            updateDB();
        }
        catch(SQLException ex) {
        
            this.price = tmpPrice;
            throw ex;
        }
    }
    
    public static boolean add(String personalNumber, int bikeId, int adminId) throws SQLException {
    
        Connection sqlConn = DB.getConnection();
        Statement stmt = sqlConn.createStatement();
        
        return stmt.execute("INSERT INTO klienti (numri_personal, bicikleta_id, admin_id, koha_dorezimit, koha_pranimit, pagesa) VALUES ('" + 
                personalNumber + "', " + 
                bikeId + ", " + 
                adminId + ", " + 
                (System.currentTimeMillis() / 1000) + ", 0, 0)");
    }
    
    private void updateDB() throws SQLException {
    
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
}
