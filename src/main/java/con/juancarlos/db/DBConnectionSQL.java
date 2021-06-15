package con.juancarlos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSQL {
    private static DBConnectionSQL dbConnectionSql = null;
    private Connection connection = null;


    public DBConnectionSQL() throws SQLException {
        String user = "admin";
        String password = "admin";
        String host = "192.168.1.37";
        String port = "3306";
        String database = "RecuperacionProgramacion";

        connection = DriverManager.getConnection("jdbc:mysql://"+ host +":"+port+"/"+database+"?"+"user="+user+"&password="+password,user,password);
    }


    public static Connection getInstance() throws SQLException{
        if(dbConnectionSql == null){
            dbConnectionSql = new DBConnectionSQL();
        }
        return dbConnectionSql.connection;
    }
}
