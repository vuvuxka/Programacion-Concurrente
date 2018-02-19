package Parte1.PR3;

public class Main {

	private static final int NPROD=5;
	private static final int NCONS=10;
	private static int n = 8; //Cambiar valor para probar la opción de Almacén de 1
	
	public static void main(String[] args) {
		Consumidor[] consumidores = new Consumidor[NCONS];
		Productor[] productores = new Productor[NPROD];
		AlmacenN a;
		
		a = new AlmacenN(n);
		
		for(int i=0; i < NPROD; i++) productores[i] = new Productor(a);
		for(int i=0; i < NCONS; i++) consumidores[i] = new Consumidor(a);
		
		
		for(int i=0; i < NPROD; i++) productores[i].start();
		for(int i=0; i < NCONS; i++) consumidores[i].start();
		
		try{
			for(int i=0; i < NPROD; i++) productores[i].join();
			for(int i=0; i < NCONS; i++) consumidores[i].join();
		}
		catch(InterruptedException e) {}
		

	}

}
