
package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiReenrantLock {

	public static void main(String[] args) {

		Task task = new Task();

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				task.firsThread();

			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				task.secondThread();

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
		
		task.showCounter();

	}

}

class Task {
	private int counter;
	private Lock lock = new ReentrantLock();

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			counter++;

		}
	}

	public void firsThread() {
		lock.lock();
		increment();
		lock.unlock();
	}

	public void secondThread() {
		lock.lock();
		increment();
		lock.unlock();
	}
	
	public void showCounter() {
		System.out.println("Counter is [ " + counter + " ]");
	}
}
