

class pi_serial {
	public static void main(String[] args) 
	{   long inicio = System.currentTimeMillis();
		long num_steps = 800000000;
		double step;
		int i;
		double x, pi, sum = 0.0;
		step = 1.0/(double) num_steps;

		for (i = 0; i < num_steps; i++){
			x = (i + 0.5) * step;
			sum = sum + 4.0 / (1.0 + x * x);
		}				
		pi = step * sum;
		long fin = System.currentTimeMillis();
		long tiempo =  fin - inicio;
		System.out.println("("+ tiempo +" milisegundos) Valor de Phi:"+pi);		
	} 
} 	