package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiCountDownLatch {
	
	public static void main(String[] args) {
		
		int arg = 3;

		CountDownLatch cdl = new CountDownLatch(arg);
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 3; i++) {
			es.submit(new Processor(cdl));
			
		}
		
		es.shutdown();// daem poniat es, chto zasabmitili vse zadaniya i novyh mojno ne jdat'
		
		
		try {
			cdl.await();// tri potoka otschit zaschelky, a chetverty - main - jdet konca otscheta v await
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Latch has been opened, main thread is proceeding!");
		

	}

}

class Processor implements Runnable{
	
	private CountDownLatch cdl;
	
	public Processor (CountDownLatch cdl) {
		this.cdl = cdl;
	}

	@Override
	public void run() {
		try {
			System.out.println("Counting down");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cdl.countDown();
		
	}
	
}
