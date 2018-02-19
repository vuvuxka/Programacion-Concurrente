package Parte1;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		try {
			//Establecer la conexión
			new OyenteServidor( new Socket("localhost",999)).start();
		} catch (IOException e) {
			System.err.println("Cliente: No se ha podido establecer la conexión.");
		}
		
	}
}
