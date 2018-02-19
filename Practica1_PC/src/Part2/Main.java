package Part2;

import Part2.HiloIncre;
import Part2.HiloDecre;

public class Main {
	protected static int n;
	private static final int M = 10000;
	private static final int N = 4;
	
	public static void main(String[] args) {
		HiloIncre[] hilosI = new HiloIncre[M];
		HiloDecre[] hilosD = new HiloDecre[M];
		Variable.set(0);
		for(int i = 0; i < M; i++)
		{
			hilosI[i] = new HiloIncre(N);
			hilosD[i] = new HiloDecre(N);
		}
		for(int i = 0; i < M; i++)
		{
			hilosI[i].start();
			hilosD[i].start();
		}
		try {
			for(int i = 0; i < M; i++)
			{
				hilosI[i].join();
				hilosD[i].join();
			}
			System.out.println("Todos los hilos han terminado. La variable es " + Variable.get());
		} catch (InterruptedException e) {}
	}

}

