package Entidades.Ventanilla;

import Entidades.Ventanilla.Estados.Cerrada;
import Entidades.Ventanilla.Estados.EstadoVentanilla;

public  class Ventanilla {

   private EstadoVentanilla estado ;

   private static int CANTIDAD_EXTRACCIONES_MAXIMAS        =   3;
   private        int cantidad_de_extracciones             =   0;
   private        int deposito                             =   0;

    public Ventanilla(){
        this.set_estado_ventanilla(new Cerrada());
    }

    public void set_estado_ventanilla(EstadoVentanilla estado){
        this.estado=estado;
        this.estado.set_estado_ventanilla(this);
    }
    public int extracciones(){
        return this.cantidad_de_extracciones;
    }

    public void aumentar_extraccion(){
        cantidad_de_extracciones++;
    }
    public boolean extraccion_disponible(){
        return this.cantidad_de_extracciones<CANTIDAD_EXTRACCIONES_MAXIMAS;
    }
    public void deposito(int un_deposito){
        this.deposito+=un_deposito;
    }

    public String estado(){
        return this.estado.estado_actual();
    }

    /**
     * Metodos de estado
     * 
     */

     public void retirar_efectivo(){
        this.estado.retirar_efectivo();
     }
     public void hacer_deposito(){
        this.estado.hacer_deposito();
     }
     public void atencion_comercial(){
        this.estado.atencion_comercial();
     }
     public void esperar_atencion(){
        this.estado.esperar_atencion();
     }
}
