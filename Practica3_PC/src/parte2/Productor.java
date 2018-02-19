package parte2;

import java.util.concurrent.Semaphore;

public class Productor extends Thread {
	
	private Almacen a;
	static private int tiempo;
	static private int cont=0;
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
		cont++;
		Producto p =  new Producto(Integer.toString(cont));
		System.out.println("Fin producci�n: " + p.getRef());
		return p;
		
	}

}
