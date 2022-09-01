import java.util.concurrent.ForkJoinPool;
// Como ver los nucleos de nuestro equipo:
//Presione Ctrl + MAYÚS + ESC para abrir el administrador de tareas.
//Seleccione la ficha rendimiento para ver el número de núcleos y procesadores lógicos de su PC.
public class Ejecutar {
    
  public static void main(String[] args) {
      
      long time_inicio = System.currentTimeMillis();
      long num_steps = 800000000;
      long inicio=0;
      // fin contiene el indice final de num_steps
      long fin=num_steps;
    
      
      double step;
		  double pi, sum = 0.0;
      // contiene el valor del step:
		  step = 1.0/(double) num_steps;

      // Crear un objeto ForkJoinPool
      ForkJoinPool object_fjp = new ForkJoinPool();

      // Imprimimos el nivel de Paralelismo del conjunto de procesos:
      System.out.println("Nivel de paralelismo: "+object_fjp.getParallelism()); 

      //Obtenemos e imprimimos el numero de procesadores disponibles del sistema:
      int  noOfCore = Runtime.getRuntime(). availableProcessors();  
      System.out.println( "El número total de núcleos disponibles en el procesador del sistema es: "  + noOfCore);  

      // obteniendo la instancia del grupo  
      //ForkJoinPool pool = ForkJoinPool.commonPool();          
  

      // Creando un objeto ForkJoinTask  
      Pi_ForkJoin_Task pi_task = new Pi_ForkJoin_Task(inicio,fin, step); 
      
      
      /*
        Enviando la tarea a el  ForkJoinPool 
        El método invoke() divide la tarea y espera sus resultados
        Alternativo se puede usar execute();
          forkJoinPool.execute(customRecursiveTask);
          int result = customRecursiveTask.join();
      */ 
 
      double results = object_fjp.invoke(pi_task);

      pi = step * results;
      long tiempo_fin = System.currentTimeMillis();
		  long tiempo =  tiempo_fin - time_inicio;
      System.out.println("("+tiempo+"  milisegundos) Phi vale: "+pi);

      /*
       * 
       *  System.out.println(
                "counter=" + counter + "." + idx +
                " activeThreads=" + pool.getActiveThreadCount() +
                " runningThreads=" + pool.getRunningThreadCount() +
                " poolSize=" + pool.getPoolSize() +
                " queuedTasks=" + pool.getQueuedTaskCount() +
                " queuedSubmissions=" + pool.getQueuedSubmissionCount() +
                " parallelism=" + pool.getParallelism() +
                " stealCount=" + pool.getStealCount());
       * 
       */
    }
  }