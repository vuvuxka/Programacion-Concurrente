package Parte2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class OyenteServidor extends Thread{
	
	private BufferedReader input;
	private PrintWriter output;
	private Socket s;
	private static String fichero = "mifich.txt";
	
	public void run(){
		while(true){
			try {
				//Establecer conexión y flujos de comunicación
				s = new Socket(OyenteCliente.HOST, 999);
				input = new BufferedReader(new InputStreamReader(s.getInputStream()));
				output = new PrintWriter(s.getOutputStream());
				
				//Mandar nombre del fichero
				output.println(fichero);
				output.flush();
				
				String tmp;
				//Lectura del fichero y escritura por output
				while((tmp = input.readLine()) != "EOF"){
					System.out.println(tmp);
				}
				//Cerrar los flujos
				try {
					output.close();
					input.close();
					s.close();
				} catch (IOException e1) {
					System.err.println("No se ha podido cerrar las conexión");
				}
			} catch (IOException e) {
				System.out.println("No se ha podido establecer la conexión");
			}
		}
	}
}
