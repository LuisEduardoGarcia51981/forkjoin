package Entidades.Ventanilla.Estados;

import java.util.Scanner;

import Entidades.Ventanilla.Ventanilla;

public class Abierta implements EstadoVentanilla{

    Scanner lab = new Scanner(System.in);

    private Ventanilla ventana ;

    @Override
    public void retirar_efectivo() {
        System.out.println("Se ha realizado una extraccion exitosa!!");
        this.ventana.aumentar_extraccion();
        if(!ventana.extraccion_disponible()){
            System.out.println("Se ha completado el cupo de hoy! vuelva mañana");
            this.ventana.set_estado_ventanilla(new Atencion());
        }
        
    }

    @Override
    public void hacer_deposito() {
        System.out.println("Ingrese una cantidad a depositar");
        ventana.deposito(lab.nextInt());
    }

    @Override
    public void atencion_comercial() {
        System.out.println("El horario de atencion comercial no esta disponible");
        
    }

    @Override
    public void esperar_atencion() {
        System.out.println("Esperando la atencion..");
    }

    @Override
    public void set_estado_ventanilla(Ventanilla estado) {
        this.ventana = estado;
    }













    
    @Override
    public String estado_actual() {
        return "Abierta cupo disponible: "+ventana.extracciones()+" / 3";
    }
    
}
