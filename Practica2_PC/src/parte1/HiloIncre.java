package parte1;

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
			while(Variable.getLock().get());
			while(Variable.getLock().getAndSet(true));
			v.incrementa();
			Variable.getLock().set(false);
		}
	}
	private Variable v;
	private int n;

}