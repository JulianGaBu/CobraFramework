/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAdmin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    static String getUserName(String dbName){
        String username;
        String line = getFileLine(dbName);
        StringTokenizer tokenizer = new StringTokenizer(line);
        
        tokenizer.nextToken();
        username = tokenizer.nextToken();
        
        return username;
    }
    
    static String getPassword(String dbName){
        String password;
        String line = getFileLine(dbName);
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
    
    private static String getFileLine(String dbName){
        Scanner configFile;
        String line = null;
        StringTokenizer tokenizer;
        
        try{
            configFile= new Scanner(new FileReader("databases.txt"));
            while(configFile.hasNextLine()){
                line = configFile.nextLine();
                tokenizer = new StringTokenizer(line);
                if(tokenizer.nextToken().equals(line)){
                    return line;
                }
                
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Config file not found");
        }
        
        return line;
    }
    

    
    
    static void writeDBNameInFile(String dbName, String username, String password){
        PrintWriter fileOut;
        
        try{
            fileOut= new PrintWriter(new FileWriter("databases.txt", true));
            fileOut.print(dbName + " " + username + " " + password);
            fileOut.close();
         }
        catch(IOException e)
        {
            System.out.println("Error en el archivo");
        }
   }
    
   static void deleteDBNameInInFile(String dbName){
       PrintWriter fileOut;
       Scanner configFile;
        String line = null;
        StringTokenizer tokenizer;
        ArrayList<String> lines = new ArrayList<>();
        
        try{
            configFile= new Scanner(new FileReader("databases.txt"));
            while(configFile.hasNextLine()){
                line = configFile.nextLine();
                tokenizer = new StringTokenizer(line);
                if(!tokenizer.nextToken().equals(dbName)){
                    lines.add(line);
                }
            }
            
            fileOut= new PrintWriter(new FileWriter("databases.txt", false));
            for(int i = 0; i<lines.size(); i++){
                fileOut.println(lines.get(i));
            }
            
            fileOut.close();
            
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Config file not found");
        } catch (IOException ex) {
            Logger.getLogger(ConfigFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
   }
}