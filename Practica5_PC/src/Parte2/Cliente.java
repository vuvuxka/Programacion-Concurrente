package Parte2;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	
	private static OyenteServidor oS;
	private String nombre;
	private String ip;
	private Socket s;
	private BufferedReader input;
	private PrintWriter output;
	
	public static void main(String[] args) {
		oS = new OyenteServidor();
		oS.start();
	}
}
