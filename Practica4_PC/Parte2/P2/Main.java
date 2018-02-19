package Parte2.P2;

public class Main {

	private static final int NPROD=5;
	private static final int NCONS=10;
	public static final int N = 250;
	
	public static void main(String[] args) {
		Consumidor[] consumidores = new Consumidor[NCONS];
		Productor[] productores = new Productor[NPROD];
		MonitorMultiBufferLC m = new MonitorMultiBufferLC();
		
		for(int i=0; i < NPROD; i++) productores[i] = new Productor(m);
		for(int i=0; i < NCONS; i++) consumidores[i] = new Consumidor(m);
		
		
		for(int i=0; i < NPROD; i++) productores[i].start();
		for(int i=0; i < NCONS; i++) consumidores[i].start();
		
		try{
			for(int i=0; i < NPROD; i++) productores[i].join();
			for(int i=0; i < NCONS; i++) consumidores[i].join();
		}
		catch(InterruptedException e) {}
		

	}

}
