package rab;

import ui.LoginWindow;
import ui.MenuWindow;
import model.Admin;
import model.Report;

public class Main {

    private static Admin admin = null;
    
    public static void main(String[] args) {

        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
        
        loginWindow.setLoginCallback((Admin adminParam) -> {
            
            Main.admin = adminParam;
            
            MenuWindow menuWindow = new MenuWindow();
            menuWindow.setVisible(true);
            menuWindow.setAdmin(admin);
        });
    }
}
