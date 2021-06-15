package con.juancarlos.ui;

import con.juancarlos.dao.DAOFactory;
import con.juancarlos.dao.Equipo.Source;

import java.util.Scanner;

public class Menu {
    public static void Menuprincipal() {
        while (true) {
            System.out.print("1) Ver los equipos\n2) equipo\n3) Borrar todos\nOpción: ");
            Scanner scanner = new Scanner(System.in);
            int opcion = Integer.parseInt(scanner.nextLine());
            if (opcion == 1) {
        System.out.println(DAOFactory.getInstance().getDaoEquipo(Source.SQL).getall());
            } else if (opcion == 2) {
                    AddEquipo addEquipo =new AddEquipo();
                    addEquipo.setVisible(true);
            } else if (opcion == 3) {
                DAOFactory.getInstance().getDaoEquipo(Source.SQL).clear();
            }
        }
    }
}
