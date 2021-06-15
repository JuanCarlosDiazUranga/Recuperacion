package con.juancarlos.dao;

import con.juancarlos.dao.Equipo.*;

import java.sql.SQLException;

public class DAOFactory {
    private  static  DAOFactory daoFactory;
    private DAOEquipo daoEquipo;




    private  DAOFactory(){

    }
    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public DAOEquipo getDaoEquipo(Source source) {
        if (daoEquipo == null){
            if (source == Source.SQL){
                daoEquipo = new DAOEquipoSQL();
            }
            else if (source == Source.ORM){
                try {
                    daoEquipo = new DAOEquipoORM();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
        return daoEquipo;
    }
}
