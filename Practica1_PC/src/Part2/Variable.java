package Part2;

public class Variable {
	
	private static int n;
	
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
