package parte2;

import java.util.concurrent.Semaphore;

public class Main {

	private static final int TCONS=5000;
	private static final int TPROD=1000;
	private static final int NPROD=5;
	private static final int NCONS=10;
	private static Semaphore empty, full;
	
	public static void main(String[] args) {
		Consumidor[] consumidores = new Consumidor[NCONS];
		Productor[] productores = new Productor[NPROD];
		empty = new Semaphore(1);
		full = new Semaphore(0);
		
		Almacen a = new Almacen1();
		
		for(int i=0; i < NPROD; i++) productores[i] = new Productor(TPROD,a, empty, full);
		for(int i=0; i < NCONS; i++) consumidores[i] = new Consumidor(TCONS,a, empty, full);
		
		for(int i=0; i < NPROD; i++) productores[i].start();
		for(int i=0; i < NCONS; i++) consumidores[i].start();
		
		try{
			for(int i=0; i < NPROD; i++) productores[i].join();
			for(int i=0; i < NCONS; i++) consumidores[i].join();
		}
		catch(InterruptedException e) {}
		

	}

}
