

public class pruebadiv {
    public static void main(String[] args) {
        long num_steps = 100;
        long inicio = 20; 
        long fin = num_steps;
        double resp=0.0;
        for (long i=0; i < num_steps;i++)
        {
            
           /*if (fin-inicio==1)
            {
                //resp=1;
            }
            else
            {*/
                long ini_izq=inicio;
                long fin_izq=((fin-inicio)/2)+inicio;
    
                long ini_der=fin_izq+1;
                long fin_der=fin;
    
                //System.out.println("ini_izq:"+ini_izq+" fin_izq: "+fin_izq+" ini_der: "+ini_der+" fin_der: "+fin_der);
    
                //inicio = ini_izq; 
                //fin = fin_izq;
                inicio = ini_der; 
                fin = fin_der;
                resp=resp+1;
            //}
           
        }
        System.out.println("Rsdpuesta final: "+resp);

    }
  }