package Parte1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	private static ServerSocket listen;
	
	public static void main(String[] args) {
		try {
			listen = new ServerSocket(999);
			while(true){
				//Crear Socket
				try {
					Socket s = listen.accept();
					(new OyenteCliente(listen, s)).start();
				} catch (IOException e) {
					System.err.println("Servidor: No se ha podido establecer la conexion");
					return;
				}
			}
		} catch (IOException e) {
			System.out.println("No se ha podido establecer el ServerSocket");
		}
	}

	public static ServerSocket getListen() {
		return listen;
	}
	
}
