package Parte1.PR3;


public class AlmacenN {
	
	public AlmacenN(int i)
	{
		n = i;
		prod = new Producto[n];
		cont = 0;
		id = 0;
	}
	
	public synchronized void almacenar(Producto producto) {
		while (cont == n) try {wait();} catch(Exception e) {e.printStackTrace();}
		System.out.println("Produciendo...");
		try {
			Thread.sleep(TPROD);
		} catch (InterruptedException e) {}
		prod[fin] = producto;
		fin = (fin+1) % n;
		cont++;
		System.out.println("Fin produccion: " + producto.getRef());
		notify();
	}

	
	public synchronized Producto extraer() {
		while(cont == 0) try {wait();} catch(Exception e) {e.printStackTrace();}
		Producto p = prod[ini];
		ini = (ini+1)%n;
		cont--;
		System.out.println("Vamos a consumir: " + p.getRef());
		try {
			Thread.sleep(TCONS);
		} catch (InterruptedException e) {}
		System.out.println("Producto consumido");
		notify();
		return p;	
	}
	

	public synchronized int getId() {
		int a = id; 
		id++;
		return a;
	}


	private Producto[] prod;
	private int ini;
	private int fin;
	private int cont;
	private int n;
	private int id;
	static final int TCONS = 100;
	static final int TPROD = 200;
}
