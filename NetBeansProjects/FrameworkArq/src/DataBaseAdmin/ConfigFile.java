/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAdmin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author rodrigopeniche
 */
public class ConfigFile {
    
    
    static String getDriverName(){
        Scanner configFile;
        String driverName = null;
        
        try{
            configFile= new Scanner(new FileReader("configfile.txt"));
            driverName = configFile.nextLine();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Config file not found");
        }
        
        return driverName;
    }
    
    static String getPort(){
        Scanner configFile;
        String port = null;
        
        try{
            configFile= new Scanner(new FileReader("configfile.txt"));
            configFile.nextLine();
            port = configFile.nextLine();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Config file not found");
        }
        
        return port;
    }
    
    static String getDBName(){
        String dbName;
        String line = getFileLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
        
        dbName = tokenizer.nextToken();
               
        return dbName;
    }
    
    static String getUserName(){
        String username;
        String line = getFileLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
        
        tokenizer.nextToken();
        username = tokenizer.nextToken();
        
        return username;
    }
    
    static String getPassword(){
        String password;
        String line = getFileLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
              
        if(tokenizer.countTokens() == 2){
            password = null;
        }
        else{
            tokenizer.nextToken();
            tokenizer.nextToken();
            password = tokenizer.nextToken();
        }
                
        return password;
    }
    
    private static String getFileLine(){
        Scanner configFile;
        String line = null;
        
        try{
            configFile= new Scanner(new FileReader("databases.txt"));
            line = configFile.nextLine();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Config file not found");
        }
        
        return line;
    }
    
}
