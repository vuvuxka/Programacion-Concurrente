package parte2_RompeEmpate;

import parte2_RompeEmpate.HiloDecre;
import parte2_RompeEmpate.HiloIncre;

public class Main {
	protected static int n;
	private static final int M = 50;
	private static final int N = 50;
	
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

