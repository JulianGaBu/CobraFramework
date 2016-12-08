/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAdmin;


import ORMapping.ORMapping;
import ORMapping.ORMapping;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;



/**
 *
 * @author rodrigopeniche
 */
public class DataBaseAdmin {
    
    public static void main(String[] args) throws SQLException {
       
        ArrayList<String> attributes = new ArrayList<>();
        attributes.add("id varchar(5) primary key");
        attributes.add("description varchar(20)");
        attributes.add("price int");
               
        DataAccessObject dao = new DataAccessObject("garci");

         ORMapping mapping = new ORMapping();
         ArrayList<Map<String, String>> data = new ArrayList<>();
         data = dao.getTuples("test");
         for(int i = 0; i< data.size(); i++){
             System.out.println();
             mapping.obtainObjectData(data.get(i));
         }
                    
       
    }   
}
