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
			while(Variable.getLock().get());
			while(Variable.getLock().getAndSet(true));
			v.decrementa();
			Variable.getLock().set(false);
		}
	}
	
	private Variable v;
	private int n;

}


