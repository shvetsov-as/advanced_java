package multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MultiProducerConsumer {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				produce();
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				consume();
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

	private static void produce() {
		Random random = new Random();
		while (true) {
			try {
				queue.put(random.nextInt(100)); // put - await for free space in the queue if its full
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void consume() {
		Random random = new Random();
		while (true) {

			try {
				Thread.sleep(100);
				if(random.nextInt(10) == 5) {
				System.out.println("TAKED ELEMENT = " + queue.take());// take - await for new element if there is no
																		// more elements in the queue
				System.out.println("QUEUE SIZE = " + queue.size());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
