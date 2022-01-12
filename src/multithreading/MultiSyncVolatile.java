package multithreading;

import java.util.Scanner;

public class MultiSyncVolatile {

	public static void main(String[] args) {

		MyThrd myThread = new MyThrd();
		myThread.start();
		
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		myThread.shutdown();

	}

}

class MyThrd extends Thread {

	private volatile boolean running = true;

	@Override
	public void run() {
		while (running) {
			System.out.println("Hello WORLD!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		this.running = false;
	}

}
