package parte1;

import java.util.concurrent.Semaphore;

public class Variable {
	
	private static int n;
	private static Semaphore sem;
	
	public Variable()
	{
		sem = new Semaphore(1);
	}
	

	public static Semaphore getSem() {
		return sem;
	}

	public void incrementa()
	{
		n++;
	}
	
	public void decrementa()
	{
		n--;
	}

	public static int get() {
		return n;
	}

	public static void set(int get) {
		Variable.n = get;
	}

}
