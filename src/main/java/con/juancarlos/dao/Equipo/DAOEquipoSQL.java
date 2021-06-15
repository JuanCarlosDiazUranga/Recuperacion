package con.juancarlos.dao.Equipo;

import con.juancarlos.db.DBConnectionSQL;
import con.juancarlos.entities.Equipo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOEquipoSQL implements DAOEquipo{
    @Override
    public Equipo add(Equipo equipo) {
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            statement.execute("insert into equipos(mac,ip) values ('" + equipo.getMac() + "','" + equipo.getIp() + "')");
        } catch (SQLException exception) {
            if (exception.getErrorCode() == 1062) {
                System.err.println("error insertar equipo");
            } else {
                System.err.println(exception.getMessage());
            }
        }

        return equipo;
    }


    @Override
    public List<Equipo>  getall() {
       List<Equipo>equipos = new ArrayList<>();
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from equipos ");
            while (resultSet.next()) {

                int ip = resultSet.getInt("ip");
                String mac = resultSet.getString("mac");


                equipos.add(new Equipo(mac, ip));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return equipos;

    }

    @Override
    public void clear() {
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            statement.execute("delete from equipos");
        }catch (SQLException exception) {
            if (exception.getErrorCode() == 1062) {
                System.err.println("error lista de equipos");
            } else {
                System.err.println(exception.getMessage());
            }
        }
    }
    }

