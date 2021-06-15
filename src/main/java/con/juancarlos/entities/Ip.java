package con.juancarlos.entities;

public class Ip {
    private int ip;

    public Ip(int ip) {
        this.ip = ip;
    }

    public int getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "Ip{" +
                "ip=" + ip +
                '}';
    }
}
