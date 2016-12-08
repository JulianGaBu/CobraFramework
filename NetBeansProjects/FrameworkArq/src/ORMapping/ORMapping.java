/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigopeniche
 */
public class ORMapping {
    
    private Map<String, String> object;
    
    public void createObject(ArrayList<String> columnNames, ResultSet resultSet){
        object = new LinkedHashMap<>();
        for(int i = 0; i< columnNames.size(); i++){
            try {
                object.put(columnNames.get(i), resultSet.getString(i+1));
            } catch (SQLException ex) {
                Logger.getLogger(ORMapping.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Map<String, String> getObject(){
        return object;
    }
    /**
     * 
     * @param object: found record
     */
    public void obtainObjectData(Map<String, String> object){
        Iterator it = object.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println("Clave: " + key + " -> Valor: " + object.get(key));
        }
    }
    
}
