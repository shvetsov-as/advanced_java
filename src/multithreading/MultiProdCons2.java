package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class MultiProdCons2 {

	public static void main(String[] args) {

		ProducerConsumer pc = new ProducerConsumer();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ProducerConsumer {

	private Queue<Integer> queue = new LinkedList<>();
	private final int LIMIT = 10;// elementov y nas v ochrerdi (bydet max)
	private final Object LOCK = new Object();// object dlia sinhronizacii

	public void produce() throws InterruptedException {

		int value = 0;

		while (true) {
			synchronized (LOCK) {
				while (queue.size() == LIMIT) {
					LOCK.wait();
				}

				queue.offer(value++);
				LOCK.notify();
			}

		}

	}

	public void consume() throws InterruptedException {

		while (true) {
			synchronized (LOCK) {
				while (queue.size() == 0) {
					LOCK.wait();
				}

				int value = queue.poll();
				System.out.println(value);
				System.out.println("Queue size is [ " + queue.size() + " ]");
				LOCK.notify();
			}

			Thread.sleep(1000);
		}
	}
}
