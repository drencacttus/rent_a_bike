package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Report {
    
    public static String generateHTML() {
    
        try {
        
            ArrayList<Client> clientList = DB.getClients();
        
            String result = "<table border=\"1\" width=\"100%\"><tr><th width=\"20%\">Bike</th><th width=\"40%\">Total time</th><th width=\"40%\">Payment</th></tr>";
            int totalTime = 0;
            float totalIncome = 0;
            
            for(Client c : clientList){
                
                if(c.getReturnTime() != 0) {
                    result += "<tr><td>" + c.getBikeId() + 
                              "</td><td>" + c.getTotalTime() + 
                              " min</td><td>" + c.getPrice() + " &euro;</td></tr>";
                
                    totalTime += c.getTotalTime();
                    totalIncome += c.getPrice();
                }
            }
            
            result += "<tr><td><strong align=\"right\">Total:</strong></td><td>" + 
                        totalTime + 
                        " min</td><td>" + 
                        totalIncome + 
                        " &euro;</td></tr>";
            
            return result;
        }
        catch(SQLException ex) {
        
            return null;
        }
    }
}
