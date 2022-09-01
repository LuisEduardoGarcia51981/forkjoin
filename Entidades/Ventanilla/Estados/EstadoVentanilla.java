package Entidades.Ventanilla.Estados;

import Entidades.Ventanilla.Ventanilla;

public interface EstadoVentanilla {

    public abstract void    retirar_efectivo();
    public abstract void    hacer_deposito();
    public abstract void    atencion_comercial();
    public abstract void    esperar_atencion();
    public abstract String  estado_actual();

    public void set_estado_ventanilla(Ventanilla estado);
}
