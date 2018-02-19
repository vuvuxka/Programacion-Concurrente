package parte3;

import java.util.concurrent.Semaphore;

public class Productor extends Thread {
	
	private Almacen a;
	static private int tiempo;
	Semaphore empty, full;
	
	public Productor (int t, Almacen al, Semaphore e, Semaphore f)
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
        	try {
				empty.acquire();
			    p = producir();
			    a.almacenar(p);
			    full.release();
        	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
    }
	
	static private Producto producir()
	{
		System.out.println("Produciendo...");
		try {
			sleep(tiempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Producto p =  new Producto();
		System.out.println("Fin producción");
		return p;
		
	}

}
