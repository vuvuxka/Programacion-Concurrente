package Part2;

public class HiloIncre extends Thread {
	
	public HiloIncre(int k)
	{
		v = new Variable();
		n = k;
	}

	public void run()
	{
		for(int i = 0; i < n; i++)
		{
			v.incrementa();
		}
	}
	private Variable v;
	private int n;

}