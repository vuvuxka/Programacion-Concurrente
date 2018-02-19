package Parte2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class OyenteCliente extends Thread{
	
	private ServerSocket listen;
	private BufferedReader input;
	private PrintWriter output;
	private static Socket s;
	public static final String HOST = ""; //Meterlo a mano

	public OyenteCliente(ServerSocket listen) {
		this.listen = listen;
	}
	
	public void run(){
		while(true){
			//Crear Socket
			try {
				s = listen.accept();
			} catch (IOException e) {
				System.err.println("No se ha podido establecer la conexión");
				return;
			}
			
			//Coger HOST
			System.out.println(s.getInetAddress().getAddress());
			
			//Establecer flujo de entrada
			try {
				input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (IOException e) {
				System.err.println("No se ha podido coger el InputStream");
				try {
					s.close();
				} catch (IOException e1) {
					System.err.println("No se ha podido cerrar la conexión del Socket");
				}
				return;
			}
			
			//Establecer flujo de salida
			try {
				output = new PrintWriter(s.getOutputStream());
			} catch (IOException e) {
				System.err.println("No se ha podido coger el OutputStream");
				try {
					input.close();
					s.close();
				} catch (IOException e1) {
					System.err.println("No se ha podido cerrar las conexión");
				}
				return;
			}
			
			//Leer nombre fichero y abrirlo y crear flujo
			try {
				FileReader fr = new FileReader(input.readLine());
				BufferedReader bufferFile = new BufferedReader(fr);
				String tmp;
				//Lectura del fichero y escritura por output
				while((tmp = bufferFile.readLine()) != null){
					output.println(tmp);
					output.flush();
				}
				output.println("EOF");
				output.flush();
				//Cerrar los flujos
				try {
					fr.close();
					bufferFile.close();
					output.close();
					input.close();
					s.close();
				} catch (IOException e1) {
					System.err.println("No se ha podido cerrar las conexión");
				}
			} catch (FileNotFoundException e){
				System.err.println("No existe el fichero");
				try {
					output.close();
					input.close();
					s.close();
				} catch (IOException e1) {
					System.err.println("No se ha podido cerrar las conexión");
				}
			} catch (IOException e) {
				System.err.println("No se ha podido leer de input o similar");
				try {
					output.close();
					input.close();
					s.close();
				} catch (IOException e1) {
					System.err.println("No se ha podido cerrar las conexión");
				}
			}
		}
	}

}
