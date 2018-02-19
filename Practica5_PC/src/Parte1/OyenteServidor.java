package Parte1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class OyenteServidor extends Thread{
	
	private BufferedReader input;
	private PrintWriter output;
	private Socket s;
	private static String[] fichero = {"C:\\hlocal\\workspace-4.4-64bits\\P5\\src\\Parte1\\mifich1.txt","C:\\hlocal\\workspace-4.4-64bits\\P5\\src\\Parte1\\mifich2.txt"};
	
	public OyenteServidor(Socket s) {
		this.s = s;
	}
	
	public void run(){
		while(true){
			try {
				//Establecer conexion y flujos de comunicacion
				input = new BufferedReader(new InputStreamReader(s.getInputStream()));
				output = new PrintWriter(s.getOutputStream());
				
				//Mandar nombre del fichero
				output.println(fichero[((new Random()).nextInt())%2]);
				output.flush();
				
				String tmp;
				//Lectura del fichero y escritura por output
				while((tmp = input.readLine()) != "EOF"){
					if (tmp!=null) System.out.println(tmp);
				}
				//Cerrar los flujos
				try {
					output.close();
					input.close();
					s.close();
				} catch (IOException e1) {
					System.err.println("OServidor: No se ha podido cerrar las conexion");
				}
			} catch (IOException e) {
				System.err.println("OServidor: No se ha podido establecer la conexion");
			}
		}
	}
}
