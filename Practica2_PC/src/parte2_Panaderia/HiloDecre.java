package parte2_Panaderia;

public class HiloDecre extends Thread {
	
	public HiloDecre(int k, int proc, int i)
	{
		v = new Variable(proc);
		n = k;
		id = i;
		m = proc;
	}

	public void run()
	{
		for(int i = 0; i < n; i++)
		{
			Variable.getTurn()[id-1] = 1;
			Variable.getTurn()[id-1] = Variable.maxTurn() + 1;
			for (int j = 1; j <= 2*m; j++)
			{
				if (j!=id)
				{
					while(Variable.getTurn()[j-1]!=0 && Variable.compare(id, j));
				}
			}
			v.decrementa();
			Variable.getTurn()[id-1] = 0;	
		}
	}
	
	private Variable v;
	private int n;
	private int id;
	private int m;

}


