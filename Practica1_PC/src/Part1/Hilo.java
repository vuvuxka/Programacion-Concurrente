package Part1;

public class Hilo extends Thread {
	
	public Hilo(String t, int tie)
	{
		super(t);
		tiempo = tie;
	}

	public void run()
	{
		System.out.println("Mi identificador es: " + this.getName());
		try {sleep(tiempo);}catch(InterruptedException e){}
		System.out.println("Mi identificador es: " + this.getName());
	}
	private int tiempo;

}
