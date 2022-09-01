package Entidades.Ventanilla.Estados;

import Entidades.Ventanilla.Ventanilla;

public class Atencion implements EstadoVentanilla{

    int personas_atendidas  =   2;

    private Ventanilla ventana ;

    @Override
    public void retirar_efectivo() {
        System.out.println("En estos horarios no puede realizarse un retiro");
        
    }

    @Override
    public void hacer_deposito() {
        System.out.println("En estos horarios no puede realizarse un deposito");
        
    }

    @Override
    public void atencion_comercial() {
        if(personas_atendidas!=0){
            System.out.println("Bienvenido al servicio de atencion");
            personas_atendidas--;

            if(personas_atendidas==0&&!ventana.extraccion_disponible()){
                System.out.println("Cupo de caja finalizada por hoy hasta luego");
                this.ventana.set_estado_ventanilla(new Cerrada());
            }

        }else{
            System.out.println("Cupo de atencion completo por hoy");
        }
    }

    @Override
    public void esperar_atencion() {
        if(ventana.extraccion_disponible()){
            System.out.println("Esperando.. por la caja");
        }else{
            System.out.println("No hay extracciones disponibles");
        }

        if(this.personas_atendidas==0){
            if(this.personas_atendidas==0 && !ventana.extraccion_disponible()){
                System.out.println("Cupo de caja finalizada por hoy hasta luego");
                this.ventana.set_estado_ventanilla(new Cerrada());
            }else{
                System.out.println("Caja abierta cupo disponible ");
                this.ventana.set_estado_ventanilla(new Abierta());
            }
        }
    }

    @Override
    public void set_estado_ventanilla(Ventanilla estado) {
        this.ventana = estado;
    }










    

    @Override
    public String estado_actual() {
        return "Atencion cupo disponible: "+this.personas_atendidas+" /2";
    }
    
}
