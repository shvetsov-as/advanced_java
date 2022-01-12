package multithreading;

import java.util.Scanner;

public class MultiWaitNotify {

	public static void main(String[] args) {

		WaitAndNotify wn = new WaitAndNotify();

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				wn.produce();

			}
		});
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				wn.consume();
			}
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class WaitAndNotify {
	public void produce() {

		synchronized (this) {
			System.out.println("Producer thread started...");

			try {
				wait();// give away intrinsic lock; waiting for notify;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Producer thread resumed...");
		}

	}

	public void consume() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Scanner sc = new Scanner(System.in)) {
			synchronized (this) {
				System.out.println("Waiting for return key pressed...");
				sc.nextLine();
				notify();
				
			}
		}

	}
}
