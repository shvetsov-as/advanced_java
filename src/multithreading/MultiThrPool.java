package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThrPool {

	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(4);

		for (int i = 0; i < 16; i++) {
			es.submit(new Work(i));
		}

		es.shutdown();


		System.out.println("All tasks submited");

		try {
			es.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Work implements Runnable {

	private int id;

	public Work(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Work [ ID = " + id + " ] was completed");

	}

}
