package Parte1.PR3;


public class Productor extends Thread {
	
	private AlmacenN a;
	
	public Productor (AlmacenN a)
	{
		this.a = a;
	}
	
	public void run() {
		Producto p;
        while (true)
        {
    		p =  new Producto(Integer.toString(a.getId()));
    		a.almacenar(p);
        }
    }
}
