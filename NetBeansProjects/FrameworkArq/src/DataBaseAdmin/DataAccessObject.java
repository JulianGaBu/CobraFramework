package DataBaseAdmin;

import ORMapping.ORMapping;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DataAccessObject extends MySQLCommands {

    private final DatabaseConnection dbConnection;
    private final Connection connection;
    private String query;
    private Statement statement;

    /**
     *
     * @param dbName db to handle
     */
    public DataAccessObject(String dbName){
        dbConnection = new DatabaseConnection();
        connection = dbConnection.getConnection(dbName);
    }

    /**
     *
     * @param tableName table to create
     * @param attributes set of attributes with datatype and constraints
     * specifications
     * e.g. name varchar(5) PRIMARY KEY
     * @throws java.sql.SQLException
     *
     *

     */
    public void createTable(String tableName, ArrayList<String> attributes) throws SQLException {

        String fields = generateTableAtributesQuery(attributes);

        query = CREATE_COMMAND + TABLE_COMMAND + tableName + fields;
        System.out.println(fields);
        statement = connection.createStatement();
        statement.executeUpdate(query);
        dbConnection.closeConnection();
        System.out.println("tabla creada exitosamente");

    }

    private String generateTableAtributesQuery(ArrayList<String> atributes){
       String fields = "(";

        for (int i = 0; i < atributes.size(); i++) {
            if (!(i == atributes.size() - 1)) {
                fields += atributes.get(i) + ", ";
            } else {
                fields += atributes.get(i) + ")";
            }
        }

        return fields;
    }
    /**
     *
     * @param tableName table to delete
     * @throws SQLException
     */
    public void dropTable(String tableName) throws SQLException {
        query = DROP_COMMAND + TABLE_COMMAND + tableName;
        statement = connection.createStatement();
        statement.executeUpdate(query);
        dbConnection.closeConnection();
        System.out.println("tabla eliminada exitosamente");
    }
    /**
     * 
     * @param tableName table to insert the data into
     * @param values  set values to insert into the table
     * @throws SQLException 
     */
    public void insertData(String tableName, ArrayList<String> values) throws SQLException {

        String fields = generateFieldValuesQuery(values);

        query = INSERT_COMMAND + INTO_COMMAND + tableName + VALUES_COMMAND + fields;
        System.out.println(query);

        statement = connection.createStatement();
        statement.executeUpdate(query);
        dbConnection.closeConnection();
        System.out.println("datos almacenados de forma exitosa");

    }
    
    private String generateFieldValuesQuery(ArrayList<String> values){
        String fields = "(";
       
        for (int i = 0; i < values.size(); i++) {            
            if (!(i == values.size() - 1)) {
                if(isNumeric(values.get(i))){
                fields +=  + Integer.parseInt(values.get(i)) + ", ";
                }
                else{
                fields += "\"" + values.get(i) + "\", ";
                }
            } 
            else {
               
                if(isNumeric(values.get(i))){
                    fields +=  + Integer.parseInt(values.get(i)) + ")";
                }
                else{
                    fields += "\"" + values.get(i) + "\")";
                }
            }
        }
        
        return fields;
    }
    
    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  
    }
    
    /**
     * 
     * @param tableName table to delete data from
     * @param rowIdentifierValue specific value from the row to delete
     * @throws java.sql.SQLException
     */
    public void deleteRecord(String tableName, String rowIdentifierValue) throws SQLException {
        String tableIdentifier = getTableIdentifier(tableName);
        query = DELETE_COMMAND + FROM_COMMAND + tableName + WHERE_COMMAND + tableIdentifier + " = \'" + rowIdentifierValue + "\'";
        
        statement = connection.createStatement();
        statement.executeUpdate(query);
        
        dbConnection.closeConnection();
        System.out.println("Registro eliminado exitosamente");
    }
    
    private String getTableIdentifier(String tableName) throws SQLException {
        String tableIdentifier;

        query = SELECT_COMMAND + ALL_COMMAND + FROM_COMMAND + tableName;
        statement = connection.createStatement();

        ResultSet resultSet;
        resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        tableIdentifier = resultSetMetaData.getColumnName(1);

        return tableIdentifier;
    }
    
    /**
     * 
     * @param tableName table where the record will be searched for
     * @param rowIdentifierValue specific value from the row to search for
     * @return the row requested which is a  Map<String, String>
     * @throws SQLException 
     */
    public Map<String, String> searchRecord(String tableName, String rowIdentifierValue) throws SQLException {
        String tableIdentifier = getTableIdentifier(tableName);
        Map<String, String> object;

        query = SELECT_COMMAND + ALL_COMMAND + FROM_COMMAND + tableName + WHERE_COMMAND
                + tableIdentifier + " = \'" + rowIdentifierValue + "\'";

        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        ArrayList<String> columnNames = getColumnNames(resultSetMetaData);
        ORMapping map = new ORMapping();
        map.createObject(columnNames, resultSet);
        object = map.getObject();
        
        dbConnection.closeConnection();
              
        return object;

    }
    /**
     * 
     * @param tableName table to retrieve
     * @return the table requested, which is a ArrayList<Map<String, String>>
     * @throws SQLException 
     */
    public ArrayList<Map<String, String>> getTuples(String tableName) throws SQLException {
        ArrayList<Map<String, String>> data = new ArrayList<>();
        Map<String, String> object;
        try {
            query = SELECT_COMMAND + ALL_COMMAND + FROM_COMMAND + tableName;
            statement = connection.createStatement();

            ResultSet resultSet;
            resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            ArrayList<String> columnNames = getColumnNames(resultSetMetaData);
            ORMapping map;

            while (resultSet.next()) {
                map = new ORMapping();
                map.createObject(columnNames, resultSet);
                object =  map.getObject();
                data.add(object);                
            }

        } catch (SQLException ex) {
            System.out.println("Data retrieving error");
        }

        return data;
    }
    
    private ArrayList<String> getColumnNames(ResultSetMetaData resultSetMetaData) throws SQLException{
         int columnsNumber = resultSetMetaData.getColumnCount();
         ArrayList<String> columnNames = new ArrayList<>();
         
         for(int i = 1; i<=columnsNumber; i++){
             columnNames.add(resultSetMetaData.getColumnName(i));
         }
        
        return columnNames;
    }
    
    public void updateRecord(String tableName, String rowIdentifierValue, ArrayList<String> attributes) throws SQLException{
        String fields;
        fields = generateUpdateFieldValuesQuery(attributes);
        //query = UPDATE_COMMAND + tableName + ;
        statement = connection.createStatement();
        statement.executeQuery(query);
         
    }
    
    private String generateUpdateFieldValuesQuery(ArrayList<String>attributes){
        return null;
    }


}
