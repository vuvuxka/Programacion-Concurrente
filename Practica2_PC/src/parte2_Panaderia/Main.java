package parte2_Panaderia;

import parte2_Panaderia.HiloDecre;
import parte2_Panaderia.HiloIncre;

public class Main {
	protected static int n;
	private static final int M = 10;
	private static final int N = 10;
	
	public static void main(String[] args) {
		HiloIncre[] hilosI = new HiloIncre[M];
		HiloDecre[] hilosD = new HiloDecre[M];
		Variable.set(0);
		for(int i = 0; i < M; i++)
		{
			hilosI[i] = new HiloIncre(N, M, i+1);
			hilosD[i] = new HiloDecre(N, M, M+i+1);
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

