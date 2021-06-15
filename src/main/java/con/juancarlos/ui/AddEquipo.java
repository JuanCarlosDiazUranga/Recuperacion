package con.juancarlos.ui;

import con.juancarlos.dao.DAOFactory;
import con.juancarlos.dao.Equipo.Source;
import con.juancarlos.entities.Equipo;
import con.juancarlos.entities.Ip;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class AddEquipo  extends JFrame {
    private JPanel root;
    private JTextField textFieldIP;
    private JTextField textFieldMAC;
    private JButton añadirButton;
    private JLabel inputip;
    private JLabel inputmac;
    private HashMap<Ip,Integer> ips;
    Equipo equipo = null;

    public AddEquipo() {
        setSize(400, 400);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(root);
        this.setHandlers();

    }



    private AddEquipo setHandlers() {
        añadirButton.addActionListener(e -> {
            DAOFactory.getInstance().getDaoEquipo(Source.SQL).add(buildequipo());
        });
        return null;
    }


    private Equipo buildequipo() {

        try {
            String mac = textFieldMAC.getText();
            int ip = Integer.parseInt(textFieldIP.getText());
            if (textFieldIP.getText().contains("1")){



                System.out.println("esta ip esta reservada");
            }else if (textFieldIP.getText().contains("255")){
                System.out.println("Esta ip esta reservada");
            }

            equipo = new Equipo(mac, ip);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,

                    "Error al crear el equipo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return equipo;
    }
    }







