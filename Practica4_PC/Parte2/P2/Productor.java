package Parte2.P2;


public class Productor extends Thread {
	
	private MonitorMultiBufferLC m;
	
	public Productor (MonitorMultiBufferLC m)
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
