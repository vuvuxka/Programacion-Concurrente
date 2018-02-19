package Parte1.PR2;

public class Main {
	
	public static final int N = 1000;
	public static final int M = 500;
	
	public static void main(String[] args) {

		SyncDI sinc = new SyncDI();
		Incr[] incr = new Incr[M];
		Decr[] decr = new Decr[M];
		
		for(int i = 0; i<M; i++){
			incr[i] = new Incr(sinc);
			decr[i] = new Decr(sinc);
		}
		
		for(int i = 0; i<M; i++){
			incr[i].start();
			decr[i].start();
		}
		
		for(int i = 0; i<M; i++){
			try {
				incr[i].join();
				decr[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(sinc.getN());
	}
}