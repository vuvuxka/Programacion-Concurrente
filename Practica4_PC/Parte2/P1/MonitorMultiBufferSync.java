package Parte2.P1;

public class MonitorMultiBufferSync {
	
	private Producto[] buffer = new Producto[Main.N];
	private int ini=0;
	private int fin=0;
	private int count=0;
	
	public synchronized void producir(){
		
		//Producir datos
		int length = 10;
		Producto[] data = new Producto[length];
    	for(int i = 0; i < length; i++)
    		data[i] = new Producto(""+i);
    	
    	//Comprobacion de ocupacion
		while(Main.N-count < data.length)
			try {
				wait();
			} catch (InterruptedException e) {}
		
		//Incorporacion al buffer
		for(int i = 0; i < data.length; i++){
			buffer[(fin + i) % Main.N] = data[i];
			System.out.println("Produciendo " + data[i].getRef() + ".");
		}
		
		fin=(fin + data.length) % Main.N;
		count = count + data.length;
		
		//Despertar a todos los consumidores
		notifyAll();
	}
	
	public synchronized void consumir(){
		
		//Comprobación de ocupacion
		int length = 15;
		while(count < length)
			try {
				wait();
			} catch (InterruptedException e) {}
		
		//Consumicion del producto
		for(int i = 0; i < length; i++){
			System.out.println("Consumiendo el producto " + buffer[(ini + i) % Main.N].getRef() + ".");
		}
		
		ini = (ini + length) % Main.N;
		count = count - length;
		
		//Despertar a todos los productores
		notifyAll();
	}
}