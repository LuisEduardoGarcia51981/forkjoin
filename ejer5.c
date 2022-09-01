#include <stdio.h>
#include <omp.h>
void main () {
   long num_steps = 800000000;
   double step;
   int i;
   int numero_de_threads;
   int id,cant_elementos,ini,final;
   int MAX_THREADS=omp_get_max_threads();
   double acum[MAX_THREADS];
   double x, pi, sum = 0.0;
   step = 1.0/(double) num_steps;
   omp_set_dynamic(1);
   numero_de_threads= omp_get_num_threads();
   #pragma omp parallel 
   {
        
        id  = omp_get_thread_num();
        cant_elementos= num_steps / numero_de_threads;
        ini=id*cant_elementos;
        // determinamos el valor final del recorrido:
        if (num_steps % numero_de_threads == 0)
        {
            final=ini + cant_elementos;
        }
        else
        if (id==numero_de_threads-1)
        {
            final=num_steps;
        }

        for (i = ini; i < final; i++)
        {

            x = (i + 0.5) * step;
            acum[id] +=  4.0 / (1.0 + x * x);
        }
   }

   for (i=0; i<MAX_THREADS;i++)
   {
       sum+=acum[i];
   }
   
   pi = step * sum;
   printf("%f\n",pi);
}
