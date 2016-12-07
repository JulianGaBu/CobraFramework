/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
    private final String dbName;
    private String username;
    private String password;

    public DatabaseConnection(String dbName){
        this.dbName = dbName;
    }
    // verificar que se puedan modificar el nombre de usuario y contrasena
    public void createDatabase(String dbName, String username, String password){
        getConfigFileInfo();
         
        String query = " CREATE DATABASE " + dbName;
        Statement statement;
        
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(port + "", "root", "");
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConfigFile.writeDBNameInFile(dbName, username, password);
     
    }
   
   public void dropDatabase(String dbName){
        try {
            getConfigFileInfo();
            
            String query = "DROP DATABASE " + dbName;
            Statement statement;
            
            Class.forName(driverName);
            connection = DriverManager.getConnection(port, "root", "");
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConfigFile.deleteDBNameInInFile(dbName);
   }
    
    
    public Connection getConnection() {
        
        getConfigFileInfo();
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
        username = ConfigFile.getUserName(dbName);
        password = ConfigFile.getPassword(dbName);
    }
    
    private void getConfigFileInfo(){
        driverName = ConfigFile.getDriverName();
        port = ConfigFile.getPort();
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
