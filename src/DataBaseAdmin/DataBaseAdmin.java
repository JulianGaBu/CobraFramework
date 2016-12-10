/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAdmin;

import ORMapping.ORMapping;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;



/**
 *
 * @author rodrigopeniche
 */
public class DataBaseAdmin {
    
    public static void main(String[] args) throws SQLException {
       
        DataAccessObject dao = new DataAccessObject("framework");

       
//        ArrayList<Map<String, String>> object = dao.getTuples("test");
//        ORMapping mapping = new ORMapping();
//        for(int i = 0; i< object.size(); i++){
//            mapping.obtainObjectData(object.get(i));
//        }
    }   
}
