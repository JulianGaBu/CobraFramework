package DataBaseAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DataAccessObject extends MySQLCommands {

    private final DatabaseConnection dbConnection;
    private final Connection connection;
    private String query;
    private Statement statement;

     
    public DataAccessObject(String tableName){
        dbConnection = new DatabaseConnection(tableName);
        connection = dbConnection.getConnection();
    }


    public void createTable(String tableName) {
        try {
                 query = CREATE_COMMAND + TABLE_COMMAND + tableName + ""
                    + "(claveVenta int(5) NOT NULL, "
                    + "claveEmpleado varchar(5) NOT NULL,"
                    + "monto double NOT NULL,"
                    + "ganancia double NOT NULL,"
                    + "fecha int(11) NOT NULL)"
                    + "ENGINE=InnoDB DEFAULT CHARSET=latin1;";
                    
            statement = connection.createStatement();
            statement.executeUpdate(query);
            dbConnection.closeConnection();
            System.out.println("tabla creada exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void dropTable(String tableName){
        try {
            query = DROP_COMMAND + TABLE_COMMAND + tableName;
            statement = connection.createStatement();
            statement.executeUpdate(query);
            dbConnection.closeConnection();
            System.out.println("tabla eliminada exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertData(String tableName, String ID, String name, String lastname, String age, String gender) {
        try {
            query = INSERT_COMMAND + INTO_COMMAND + VALUES_COMMAND + "("
                    + "\"" + ID + "\", "
                    + "\"" + name + "\", "
                    + "\"" + lastname + "\", "
                    + "\"" + age + "\", "
                    + "\"" + gender + "\")";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }

    public void getValues(String tableName) {
        try {
            query = SELECT_COMMAND + ALL_COMMAND + FROM_COMMAND + tableName;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("ID") + " "
                        + "Nombre: " + resultSet.getString("Nombre") + " " + resultSet.getString("Apellido") + " "
                        + "Edad: " + resultSet.getString("Edad") + " "
                        + "Sexo: " + resultSet.getString("Sexo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }

    public void deleteRecord(String tableName, String ID) {
        try {
            query = DELETE_COMMAND + FROM_COMMAND + tableName + WHERE_COMMAND + " ID = \"" + ID + "\"";
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
    
    public void alterTable(String tableName) throws SQLException{
        query = "alter table " 
                    + tableName 
                + " ADD CONSTRAINT ventas_ibfk_1 FOREIGN KEY (ClaveEmpleado) REFERENCES empleados (Clave);";
                
             
        statement = connection.createStatement();
        statement.executeUpdate(query);
    }
    

}
