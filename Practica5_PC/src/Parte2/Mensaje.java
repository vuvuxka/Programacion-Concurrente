package Parte2;

public abstract class Mensaje {

	private String tipo;
	private String origen;
	private String destino;
	
	public abstract int getTipo();
	
	public abstract String getOrigen();
	
	public abstract String getDestino();
}
