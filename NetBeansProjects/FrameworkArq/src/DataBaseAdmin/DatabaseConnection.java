/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigopeniche
 */
public class DatabaseConnection {
    
    private static Connection connection;
    
    private String driverName;
    private String port;
    private String dbName;
    private String username;
    private String password;

    
    public Connection getConnection() {
        
        getDatabaseInfo();
        
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(port + dbName, username, password);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
    
    private void getDatabaseInfo(){
        driverName = ConfigFile.getDriverName();
        port = ConfigFile.getPort();
        dbName = ConfigFile.getDBName();
        username = ConfigFile.getUserName();
        password = ConfigFile.getPassword();
    }
    
    
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
