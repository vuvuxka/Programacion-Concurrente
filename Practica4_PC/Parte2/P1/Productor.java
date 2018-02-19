package Parte2.P1;


public class Productor extends Thread {
	
	private MonitorMultiBufferSync m;
	
	public Productor (MonitorMultiBufferSync m)
	{
		this.m = m;
	}
	
	public void run() {
        while (true)
        {
			m.producir();
        }
    }
}
