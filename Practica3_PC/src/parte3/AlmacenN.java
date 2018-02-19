package parte3;


public class AlmacenN implements Almacen {
	
	public AlmacenN(int i)
	{
		n = i;
		prod = new Producto[n];
	}
	
	public void almacenar(Producto producto) {
		prod[fin] = producto;
		fin = (fin+1) % n;
	}

	
	public Producto extraer() {
		Producto p = prod[ini];
		ini = (ini+1)%n;
		return p;	
	}

	private Producto[] prod;
	private int ini;
	private int fin;
	private int n;
}
