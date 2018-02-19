package parte2_Ticket;

public class HiloDecre extends Thread {
	
	public HiloDecre(int k, int proc, int i)
	{
		v = new Variable(proc);
		n = k;
		id = i;
	}

	public void run()
	{
		for(int i = 0; i < n; i++)
		{
			Variable.getTurn()[id-1] = Variable.getNumber().getAndAdd(1);	
			while(Variable.getTurn()[id-1] != Variable.getNext());
			v.decrementa();
			Variable.incNext();
			
		}
	}
	
	private Variable v;
	private int n;
	private int id;

}


