package parte2_RompeEmpate;

import java.util.Arrays;

public class Variable {
	
	private static volatile int n;
	private static volatile int[] in;
	private static volatile int[] last;
	
	public Variable(int proc)
	{
		if (in == null){
			in = new int[2*proc];
			Arrays.fill(in, 0);
		}		
		if (last == null){
			last = new int[2*proc];
			Arrays.fill(last, 0);
		}
	}
	

	public static int[] getIn() {
		return in;
	}


	public static int[] getLast() {
		return last;
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
