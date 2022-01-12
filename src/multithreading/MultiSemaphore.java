package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MultiSemaphore {

	public static void main(String[] args) {

		ExecutorService ex = Executors.newFixedThreadPool(200);
		Connection connection = Connection.getConnection();

		for (int i = 0; i < 200; i++) {
			ex.submit(new Runnable() {

				@Override
				public void run() {
					connection.work();

				}
			});
		}
		ex.shutdown();

		try {
			ex.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Connection {

	private static Connection connection = new Connection();
	private int connectionsCount;

	private Semaphore sem = new Semaphore(10);

	private Connection() {

	}

	public static Connection getConnection() {
		return connection;
	}

	public void work() {

		try {
			sem.acquire();

			doWork();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sem.release(); //obiazatelno v bloke FINALLY, chtobbI tochno otdat' razreshenie semaforu esli bydet iskluchenie
		}

	}

	private void doWork() throws InterruptedException {
		synchronized (this) {
			connectionsCount++;
			System.out.println("connections count " + connectionsCount);
		}

		Thread.sleep(5000);// rabota s soedineniem

		synchronized (this) {
			connectionsCount--;
		}
	}
}
