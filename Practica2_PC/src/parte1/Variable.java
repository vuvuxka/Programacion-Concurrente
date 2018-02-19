package parte1;

import java.util.concurrent.atomic.AtomicReference;

public class Variable {
	
	private static int n;
	private static AtomicReference<Boolean> lock;
	
	public Variable()
	{
		lock = new AtomicReference<Boolean>(false);
	}
	
	public static AtomicReference<Boolean> getLock() {
		return lock;
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
