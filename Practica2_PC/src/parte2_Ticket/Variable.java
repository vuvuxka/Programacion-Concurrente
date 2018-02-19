package parte2_Ticket;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Variable {
	
	private static volatile int n;
	private static volatile int[] turn;
	private static volatile AtomicInteger number;
	private static volatile int next;
	
	
	public Variable(int proc)
	{
		if (turn == null){
			turn = new int[2*proc];
			Arrays.fill(turn, 0);
		}
		if (number == null) number = new AtomicInteger(1);
		next = 1;
	}
	

	public static int getNext() {
		return next;
	}


	public static void incNext() {
		Variable.next++;
	}


	public static int[] getTurn() {
		return turn;
	}


	public static AtomicInteger getNumber() {
		return number;
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
