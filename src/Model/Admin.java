package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin {
 
    private int id;
    private String username;
    private String password;
    private String salt;
    private String name;

    public Admin(ResultSet rs) throws SQLException {
    
        id = rs.getInt("id");
        username = rs.getString("username");
        password = rs.getString("password");
        salt = rs.getString("salt");
        name = rs.getString("name");
    }
    
    public int getId() {
        return id;
    }

    public String getPasswordHash() {
        return password;
    }

    public void setPassword(String password) throws SQLException {
        
        String tmpPassword = this.password;
        
        try {
            
            this.password = Helpers.getPasswordHash(password + salt);
            updateDB();
        }
        catch(SQLException ex) {
        
            this.password = tmpPassword;
            throw ex;
        }
    }

    public String getSalt() {
        return salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws SQLException {
        
        String tmpName = this.name;
        
        try {
            
            this.name = name;
            updateDB();
        }
        catch(SQLException ex) {
        
            this.name = tmpName;
            throw ex;
        }
    }

    public String getUsername() {
        return username;
    }
    
    private void updateDB() throws SQLException {
    
//        try {
//        
            Connection sqlConn = DB.getConnection();
            Statement stmt = sqlConn.createStatement();
            stmt.executeUpdate("UPDATE admin SET name='" + 
                                name + 
                                "', password='" + 
                                password + 
                                "' WHERE id=" + id);
            
            stmt.close();
            sqlConn.close();
//        }
//        catch(SQLException ex) {
//        
//        }
    }
}
