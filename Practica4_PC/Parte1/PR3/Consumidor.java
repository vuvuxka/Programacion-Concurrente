package Parte1.PR3;

public class Consumidor extends Thread {
	
	private AlmacenN a;
	
	public Consumidor(AlmacenN a)
	{
		this.a = a;
	}
	
	public void run() {
		@SuppressWarnings("unused")
		Producto p;
        while (true)
        {
        	p = a.extraer();
        }
    }


}
