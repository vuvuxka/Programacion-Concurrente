package Parte1.PR2;

public class Incr extends Thread {
	
	SyncDI s;
	
	public Incr(SyncDI s) {
		this.s = s;
	}
	
	public void run() {
		s.incr();
	}
}