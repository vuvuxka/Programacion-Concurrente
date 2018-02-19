package Parte2.P2;

public class Consumidor extends Thread {
	
	private MonitorMultiBufferLC m;
	
	public Consumidor(MonitorMultiBufferLC a)
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
