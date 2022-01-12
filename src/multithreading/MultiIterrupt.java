package multithreading;

import java.util.Random;

public class MultiIterrupt {
	public static void main(String[] args) {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				
				Random random = new Random();
				for (int i = 0; i < 1_000_000_000; i++) {
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("thread is interrupted");
						break;
					}
					Math.sin(random.nextDouble());
				}

			}
		});

		System.out.println("Starting thread");
		

		thread.start();
		
		try {
			
		Thread.sleep(1000);
		
		thread.interrupt();
		
		
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("Thread has finished");
	}
}
