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

    public void setTypeName(String typeName, boolean shouldUpdateDB) throws SQLException {
        
        String tmpTypeName = this.typeName;
        
        try {
            
            this.typeName = typeName;
            if(shouldUpdateDB)
                updateDB();
        }
        catch(SQLException ex) {
        
            this.typeName = tmpTypeName;
            throw ex;
        }
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price, boolean shouldUpdateDB) throws SQLException {
        
        float tmpPrice = this.price;
        
        try {
            
            this.price = price;
            if(shouldUpdateDB)
                updateDB();
        }
        catch(SQLException ex) {
        
            this.price = tmpPrice;
            throw ex;
        }
    }
    
    public boolean delete() throws SQLException {
    
        Connection sqlConn = DB.getConnection();
        Statement stmt = sqlConn.createStatement();
        
        return stmt.execute("DELETE FROM bicikleta_llojet WHERE id=" + id);
    }
    
    public static boolean add(String typeName, float price) throws SQLException {
            
        Connection sqlConn = DB.getConnection();
        Statement stmt = sqlConn.createStatement();
        
        return stmt.execute("INSERT INTO bicikleta_llojet (lloji, cmimi) VALUES ('" + typeName + "', " + price + ")");
    }
    
    private void updateDB() throws SQLException {

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
    
    @Override
    public String toString() {
    
        return getTypeName();
    }
}
