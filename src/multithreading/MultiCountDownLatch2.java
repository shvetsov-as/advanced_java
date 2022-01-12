package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiCountDownLatch2 {
	
	public static void main(String[] args) {

		CountDownLatch cdl = new CountDownLatch(3);
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 3; i++) {
			es.submit(new Processor2(i, cdl));
			
		}
		
		es.shutdown();// daem poniat es, chto zasabmitili vse zadaniya i novyh mojno ne jdat'
		
		for (int i = 0; i < 3; i++) {
			
			try {
				Thread.sleep(1000);
				System.out.println("Counting latch to iteraion " + (i + 1) + " of 3");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			cdl.countDown();
		}

	}

}

class Processor2 implements Runnable{
	
	private int id;	
	private CountDownLatch cdl;
	
	
	public Processor2 (int id, CountDownLatch cdl) {
		this.id = id;
		this.cdl = cdl;
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread " + id + " awaiting...");
			Thread.sleep(3000);
		
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread " + id + " proceeded...");
	}
	
}
