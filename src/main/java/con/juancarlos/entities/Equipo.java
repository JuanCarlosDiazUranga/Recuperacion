package con.juancarlos.entities;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Equipo implements Serializable {
    @DatabaseField
    private String mac;
    @DatabaseField(id = true)
    private int ip;


    public Equipo(String mac, Integer ip) {
        this.mac = mac;
        this.ip= ip;


    }
    public Equipo(){}


    public String getMac() {
        return mac;
    }

    public int getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "mac='" + mac + '\'' +
                ", ip=" + ip +
                '}';
    }
}

