package Entidades.Ventanilla.Estados;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Ventanilla.Ventanilla;

public class Cerrada implements EstadoVentanilla {

    private Ventanilla ventana ;

    @Override
    public void set_estado_ventanilla(Ventanilla estado) {
      this.ventana=estado;
    }

    @Override
    public void retirar_efectivo() {
        System.out.println("Ventanilla cerrada");
    }

    @Override
    public void hacer_deposito() {
        System.out.println("Ventanilla cerrada");
    }

    @Override
    public void atencion_comercial() {
        System.out.println("Esperando la atencion ");
    }

    @Override
    public void esperar_atencion() {
        System.out.println("La ventanilla esta cerrada, abrira su atencion en 10 min");
        this.ventana.set_estado_ventanilla(new Atencion());
    }


















    
    @Override
    public String estado_actual() {
        return "Cerrada";
    }

}
