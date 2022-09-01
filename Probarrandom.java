import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Probarrandom {
    
    public static void main(String[] args) {

        String[] lineas_aereas={"Aerolineas Argentinas","Lade","Flybondi","Jet Smart", "Air Europa", "American Airlines","Iberia"};
        

       
        String seleccion=lineas_aereas[Math.round((float) (Math.random()*(lineas_aereas.length-1)))];
        System.out.println(seleccion);
    }
}