package multithreading;

public class MultiSync {

	private int counter;

	public static void main(String[] args) {

		MultiSync test = new MultiSync();

		test.doWork();

	}

	public synchronized void increment() {
		counter++;
	}

	public void doWork() {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
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

		System.out.println(counter);
	}
}
