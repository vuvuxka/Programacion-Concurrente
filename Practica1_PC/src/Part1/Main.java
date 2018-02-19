package Part1;

public class Main {
	private static final int N = 5;
	private static final int T = 500;
	public static void main(String[] args) {
		Hilo[] hilos = new Hilo[N];
		for(int i = 0; i < N; i++)
		{
			hilos[i] = new Hilo(String.valueOf(i+1), T+i*100);
		}
		for(int i = 0; i < N; i++)
		{
			hilos[i].start();
		}
		try {
			for(int i = 0; i < N; i++)
			{
				hilos[i].join();
			}
			System.out.println("Todos los hilos han terminado");
		} catch (InterruptedException e) {}
	}

}
