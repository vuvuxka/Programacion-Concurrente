package Parte2.P2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorMultiBufferLC {
	
	private Producto[] buffer = new Producto[Main.N];
	private int ini=0;
	private int fin=0;
	private int count=0;
	private final Lock l = new ReentrantLock();
	private final Condition lleno = l.newCondition();
	private final Condition vacio = l.newCondition();
	
	public void producir(){
		
		//Producir datos
		l.lock();
		int length = 10;
		Producto[] data = new Producto[length];
    	for(int i = 0; i < length; i++)
    		data[i] = new Producto(""+(fin+i));
    	
    	//Comprobacion de ocupacion
		while(Main.N-count < data.length)
			try {
				vacio.await();
			} catch (InterruptedException e) {}
		
		//Incorporacion al buffer
		/*for(int i = 0; i < data.length; i++){
			buffer[(fin + i) % Main.N] = data[i];
			System.out.println("Produciendo " + data[i].getRef() + ".");
		}*/
		for(int i=0; i < data.length; i++)
		{
			buffer[(fin+i) % Main.N] = data[i];
		}
		
		System.out.println("Produciendo del " + data[0].getRef() + " al " + data[data.length-1].getRef());
		
		fin=(fin + data.length) % Main.N;
		count = count + data.length;
		
		
		//Despertar a todos los consumidores
		lleno.signalAll();
		l.unlock();
	}
	
	public void consumir(){
		
		//Comprobacion de ocupacion
		l.lock();
		int length = 15;
		while(count < length)
			try {
				lleno.await();
			} catch (InterruptedException e) {}
		
		//Consumicion del producto
		/*for(int i = 0; i < length; i++)
			System.out.println("Consumiendo el producto " + buffer[(ini + i) % Main.N].getRef() + ".");
		*/
		System.out.println("Consumiendo del " + buffer[ini % Main.N].getRef() + " al " + buffer[(ini + length - 1) % Main.N].getRef()); 
		ini = (ini + length) % Main.N;
		count = count - length;
		
		//Despertar a todos los productores
		vacio.signalAll();
		l.unlock();
	}
}