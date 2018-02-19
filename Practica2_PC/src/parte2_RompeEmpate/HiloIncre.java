package parte2_RompeEmpate;

public class HiloIncre extends Thread {
	
	public HiloIncre(int k, int proc, int i)
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
			for(int j = 1; j <= 2*m; j++)
			{
				Variable.getIn()[id-1]=j;
				Variable.getLast()[j-1]=id;
				for(int k = 1; k <= 2*m; k++)
				{
					if (k!=id)
					{
						while(Variable.getIn()[k-1]>=Variable.getIn()[id-1] && Variable.getLast()[j-1]==id);
					}
				}

			}
			v.incrementa();
			Variable.getIn()[id-1]=0;
			
		}
	}
	private Variable v;
	private int n;
	private int m;
	private int id;

}