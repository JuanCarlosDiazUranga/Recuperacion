package con.juancarlos.dao.Equipo;

import con.juancarlos.entities.Equipo;

import java.util.List;

public interface DAOEquipo {
    public Equipo add (Equipo equipo);
    public List<Equipo> getall();
    public  void clear();
}
