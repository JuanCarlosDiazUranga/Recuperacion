package con.juancarlos.dao.Equipo;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import con.juancarlos.db.DBConnectionORM;
import con.juancarlos.entities.Equipo;

import java.sql.SQLException;
import java.util.List;

public class DAOEquipoORM implements DAOEquipo{
    Dao<Equipo, String> daorecetasORM;

    public DAOEquipoORM() throws SQLException {
        this.daorecetasORM = DaoManager.createDao(
                DBConnectionORM.getInstance(),
                Equipo.class
        );
        DaoManager.registerDao(
                DBConnectionORM.getInstance(),
                daorecetasORM);
    }



    @Override
    public Equipo add(Equipo equipo) {
        try {
            daorecetasORM.create(equipo);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return equipo;
    }

    @Override
    public List<Equipo> getall() {
        try {
            return daorecetasORM.queryForAll();
        } catch (SQLException throwables) {
            return null;
        }
    }


    @Override
    public void clear() {
        try {
            daorecetasORM.delete(getall());
        }catch (SQLException throwables) {

        }
    }
    }

