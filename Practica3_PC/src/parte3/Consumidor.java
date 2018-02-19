package parte3;

import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {
	
	private Almacen a;
	private static int tiempo;
	private Semaphore empty, full;
	
	public Consumidor(int t, Almacen al, Semaphore e, Semaphore f)
	{
		tiempo = t;
		a = al;
		empty = e;
		full = f;
	}
	
	public void run() {
		Producto p;
        while (true)
        {
        	try{
	        	full.acquire();
	        	p = a.extraer();
	        	consumir(p);
	        	empty.release();
        	}catch(InterruptedException e){}
        }
    }
	
	static private void consumir(Producto p)
	{
		System.out.println("Vamos a consumir");
		try {
			sleep(tiempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Producto consumido");
		
	}

}
