package Entidades.Ventanilla;

import java.util.Scanner;

public class Banco {

    static String format = "%20s %60s";
    Scanner lab = new Scanner(System.in);

    private Ventanilla ventana;

    public Banco() {

        this.ventana = new Ventanilla();

    }

    public void menu() {

        do {
            System.out.println("_____________________________________________________________________________________");
            System.out.println("                      Banco FAI  ESTADO: " + ventana.estado());
            System.out.println("_____________________________________________________________________________________");
            System.out.printf(format, "N°", "OPCION");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.format(format, "1 |", "Hacer deposito");
            System.out.println("");
            System.out.format(format, "2 |", "Retirar efectivo");
            System.out.println("");
            System.out.format(format, "3 |", "Acceder a Caja");
            System.out.println("");
            System.out.format(format, "4 |", "Solicitar atencion comercial");
            System.out.println("");
            System.out.format(format, "5 |", "Irme del Banco");
            System.out.println("");
            System.out.println("____________________________________________________________________________________");

        } while (opcion(lab.next()));
    }

    public boolean opcion(String opcion) {
        boolean sesion = true;
        int opcion_numerica = 0;
        try {
            opcion_numerica = Integer.parseInt(opcion);
            switch (opcion_numerica) {
                case 1:
                    this.ventana.hacer_deposito();
                    break;
                case 2:
                    this.ventana.retirar_efectivo();
                    break;
                case 3:
                    this.ventana.esperar_atencion();
                    break;
                case 4:
                    this.ventana.atencion_comercial();
                    break;
                case 5:
                    sesion = false;
                    break;
                default:
                    System.out.println("Error de opcion ingrese una opcion valida");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("");
        }
        return sesion;

    }
}