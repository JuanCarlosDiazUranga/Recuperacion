package con.juancarlos.dao.Equipo;

import con.juancarlos.entities.Equipo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class DAOEquipoSerializable  implements DAOEquipo {
    private final String file = "equipos";
    HashMap<Equipo, List<String>> equipoListHashMap;

    public DAOEquipoSerializable() {
        read();
        if (equipoListHashMap == null) {
            equipoListHashMap = new HashMap<>();
        }
    }

    @Override
    public Equipo add(Equipo equipo) {
        equipoListHashMap.put(equipo,new ArrayList<>());
        save();
        return equipo;
    }

    @Override
    public List<Equipo> getall() {
        Set<Equipo> set = equipoListHashMap.keySet();
        return new ArrayList<>(set);
    }

    @Override
    public void clear() {
        equipoListHashMap.clear();
        save();
    }
    private void save(){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(equipoListHashMap);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(){
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.equipoListHashMap = (HashMap<Equipo, List<String>>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
