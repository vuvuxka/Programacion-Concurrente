package parte2;


public class Almacen1 implements Almacen {
	
	
	public void almacenar(Producto producto) {
		prod = producto;
	}

	
	public Producto extraer() {
		
		return prod;
	}

	private Producto prod;
}
