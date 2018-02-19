package Parte2.P1;

public class Consumidor extends Thread {
	
	private MonitorMultiBufferSync m;
	
	public Consumidor(MonitorMultiBufferSync a)
	{
		this.m = a;
	}
	
	public void run() {
        while (true)
        {
        	m.consumir();
        }
    }

}
