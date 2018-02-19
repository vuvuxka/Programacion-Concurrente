package Parte1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class OyenteCliente extends Thread{
	
	@SuppressWarnings("unused")
	private static ServerSocket listen;
	private BufferedReader input;
	private PrintWriter output;
	private Socket s;
	
	public OyenteCliente(ServerSocket l, Socket s) {
		listen = l;
		this.s = s;
	}
	
	public void run(){
				
			//Establecer flujo de entrada
			try {
				input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (IOException e) {
				System.err.println("No se ha podido coger el InputStream");
				System.err.println(e.getMessage());
				try {
					s.close();
				} catch (IOException e1) {
					System.err.println("No se ha podido cerrar la conexion del Socket");
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
					System.err.println("OCliente: No se ha podido cerrar las conexión");
				}
				return;
			}
			
			//Leer nombre fichero y abrirlo y crear flujo
			try {
				String arch = input.readLine();
				System.out.println(arch);
				File f = new File(arch);
				FileReader fr = new FileReader(f);
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
