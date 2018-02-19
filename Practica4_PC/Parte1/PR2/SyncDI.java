package Parte1.PR2;

public class SyncDI {
	
	private int n = 0;
	
	public synchronized int getN() {
		return n;
	}

	public synchronized void incr()
	{
		for(int i = 0; i<Main.N; i++)
			n++;
	}
	
	public synchronized void decr()
	{
		for(int i = 0; i<Main.N; i++)
			n--;
	}
	
}
