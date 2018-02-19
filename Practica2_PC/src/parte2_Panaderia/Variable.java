package parte2_Panaderia;

import java.util.Arrays;

public class Variable {
	
	private static volatile int n;
	private static volatile int[] turn;
	
	
	public Variable(int proc)
	{
		if (turn == null){
			turn = new int[2*proc];
			Arrays.fill(turn, 0);
		}
	}
	
	public static int maxTurn()
	{
		int max = 0;
		for (int t = 0; t < turn.length; t++) {
	        if (turn[t] > max) {
	            max = turn[t];
	        }
	    }
	    return max;
	}
	
	public static boolean compare(int i, int j)
	{
		return (turn[i-1] > turn[j-1]) || (turn[i-1] == turn[j-1] && i > j);
	}
	
	public static int[] getTurn() {
		return turn;
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
