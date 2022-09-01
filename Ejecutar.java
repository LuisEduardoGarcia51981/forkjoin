import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class Ejecutar {
    public static void main(String[] args) {
      long time_inicio = System.currentTimeMillis();
      long num_steps = 800000000;
      long inicio=0;
      // fin contiene el indice final de num_steps
      long fin=num_steps;
    
      // contiene el valor del step
      double step;
		  double pi, sum = 0.0;
		  step = 1.0/(double) num_steps;


      // Creating an object of the ForkJoinPool class  
      //ForkJoinPool fjp = ForkJoinPool.commonPool();  
      ForkJoinPool fjp = new ForkJoinPool();
      System.out.println("Nivel de paralelismo: "+fjp.getParallelism()); 
      int  noOfCore = Runtime.getRuntime(). availableProcessors();  
  
      System.out.println( "El número total de núcleos disponibles en el procesador del sistema es: "  + noOfCore);  

      // obteniendo la instancia del grupo  
      ForkJoinPool Pool = ForkJoinPool.commonPool();  
        
      System.out.println( "Número total de subprocesos activos antes de invocar: "  + Pool.getActiveThreadCount());  


      // Now creating an object of the SearchWork class  
      Pi_ForJoin_Task sw = new Pi_ForJoin_Task(inicio,fin, step);  
      // submitting the task to the ForkJoinPool  
      double results = fjp.invoke(sw);
      System.out.println( "Número total de subprocesos activos después de la invocación: "  + Pool.getActiveThreadCount());    
      System.out.println( "El tamaño del Common Pool es: "  + Pool.getPoolSize());  

      pi = step * results;
      long tiempo_fin = System.currentTimeMillis();
		  long tiempo =  tiempo_fin - time_inicio;
      System.out.println("("+tiempo+"  milisegundos) Phi vale: "+pi);
    }
  }