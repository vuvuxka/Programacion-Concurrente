package parte1;

public class HiloDecre extends Thread {
	
	public HiloDecre(int k)
	{
		v = new Variable();
		n = k;
	}

	public void run()
	{
		for(int i = 0; i < n; i++)
		{
			try {
				Variable.getSem().acquire();
				v.decrementa();
				Variable.getSem().release();
				} catch (InterruptedException e)
				{
					System.out.println("Error: hilo interrumpido");
				}
		}
	}
	
	private Variable v;
	private int n;

}


