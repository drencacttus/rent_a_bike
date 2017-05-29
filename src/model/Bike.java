package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bike {
    
    private int id;
    private int typeId;
    private String color;
    private int status;

    public Bike(ResultSet rs) throws SQLException {
    
        id = rs.getInt("id");
        typeId = rs.getInt("lloji_id");
        color = rs.getString("ngjyra");
    }
    
    public int getId() {
        return id;
    }
    
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) throws SQLException {
        
        int tmpTypeId = this.typeId;
        
        try {
            
            this.typeId = typeId;
            updateDB();
        }
        catch(SQLException ex) {
        
            this.typeId = tmpTypeId;
            throw ex;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws SQLException {
        
        String tmpColor = this.color;
        
        try {
            
            this.color = color;
            updateDB();
        }
        catch(SQLException ex) {
        
            this.color = tmpColor;
            throw ex;
        }
    }

    public boolean getStatus() {
        return status != 0;
    }

    public void setStatus(boolean status) throws SQLException {
        
        int tmpStatus = this.status;
        
        try {
            
            this.status = status ? 1 : 0;
            updateDB();
        }
        catch(SQLException ex) {
        
            this.status = tmpStatus;
            throw ex;
        }
    }
    
    private boolean delete() throws SQLException {
        
        Connection sqlConn = DB.getConnection();
        Statement stmt = sqlConn.createStatement();
        
        return stmt.execute("DELETE FROM bicikleta WHERE id=" + id);
    }
    
    public static boolean add(int typeId, String color) throws SQLException {
            
        Connection sqlConn = DB.getConnection();
        Statement stmt = sqlConn.createStatement();
        
        return stmt.execute("INSERT INTO bicikleta (lloji_id, ngjyra, statusi) VALUES (" + typeId + ", '" + color + "', 0)");
    }
    
    
    private void updateDB() throws SQLException {
    
        Connection sqlConn = DB.getConnection();
        Statement stmt = sqlConn.createStatement();
        stmt.executeUpdate("UPDATE bicikleta set lloji_id=" + 
                            typeId + 
                            ", ngjyra='" + 
                            color + 
                            "' WHERE id=" + 
                            id);

        stmt.close();
        sqlConn.close();
    }
}
