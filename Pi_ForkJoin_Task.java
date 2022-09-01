
import java.util.concurrent.RecursiveTask;

public class Pi_ForkJoin_Task extends RecursiveTask<Double> {
  
  // inicio contiene el indice inicial de num_steps
  private final long inicio;
 
  // fin contiene el indice final de num_steps
  private final long fin;

  // contiene el valor del step
    private final double step;

  //Implementamos el constructor de la clase
  public Pi_ForkJoin_Task(long inicio, long fin, double step) {
    this.inicio = inicio;
    this.fin = fin;
    this.step = step;
  }
 //Implementamos el metodo compute()
  
  @Override
  protected Double  compute() {

    double x, sum = 0.0;
  
    if (fin-inicio<=100) {
    
      for (long i = inicio; i <= fin; i++){
        x = (i + 0.5) * step;
        sum = sum + 4.0 / (1.0 + x * x);
      }
    }
    else
    {      
      long ini_izq=inicio;
      long fin_izq=((fin-inicio)/2)+inicio;
    
      long ini_der=fin_izq+1;
      long fin_der=fin;

      Pi_ForkJoin_Task task_left = new Pi_ForkJoin_Task(ini_izq,fin_izq, step);
      
      Pi_ForkJoin_Task task_right = new Pi_ForkJoin_Task(ini_der,fin_der, step);
      task_left.fork();
      task_right.fork();
      sum= task_left.join() + task_right.join();
    }
  
   
    return sum;
  }
}