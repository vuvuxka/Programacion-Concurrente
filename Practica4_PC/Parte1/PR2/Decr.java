package Parte1.PR2;

public class Decr extends Thread {
	
	SyncDI s;
	
	public Decr(SyncDI s) {
		this.s = s;
	}
	
	public void run() {
		s.decr();
	}
}