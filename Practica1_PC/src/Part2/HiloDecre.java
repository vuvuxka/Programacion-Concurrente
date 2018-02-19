package Part2;

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
			v.decrementa();
		}
	}
	
	private Variable v;
	private int n;

}


