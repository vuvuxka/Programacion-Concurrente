package Parte2;

import java.io.IOException;
import java.net.ServerSocket;

public class Servidor {
	
	private static ServerSocket listen;
	private Usuario[] usuarios;
	
	public static void main(String[] args) {
		try {
			listen = new ServerSocket(999);
			while(true){
				(new OyenteCliente(listen)).start();
			}
		} catch (IOException e) {
			System.out.println("No se ha podido establecer el ServerSocket");
		}
	}
	
}
