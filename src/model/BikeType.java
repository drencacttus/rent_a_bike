package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BikeType {
    
    private int id;
    private String typeName;
    private float price;

    public BikeType(ResultSet rs) throws SQLException {
    
        id = rs.getInt("id");
        typeName = rs.getString("lloji");
        price = rs.getFloat("cmimi");
    }
    
    public int getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        
        this.typeName = typeName;
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
            stmt.executeUpdate("UPDATE bicikleta_llojet SET lloji='" + 
                                typeName + 
                                "', cmimi=" + 
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
