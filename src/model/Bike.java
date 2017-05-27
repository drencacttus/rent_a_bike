package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Bike {
    
    private int id;
    private int typeId;
    private String color;

    public int getId() {
        return id;
    }
    
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        
        this.typeId = typeId;
        updateDB();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        
        this.color = color;
        updateDB();
    }
    
    private void updateDB() {
    
        try {
        
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
        catch(SQLException ex) {
        
        }
    }
}
