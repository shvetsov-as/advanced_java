package multithreading;

public class MultiTest {

	public static void main(String[] args) {

		MyTest myTest = new MyTest();
		MyTest myTest2 = new MyTest();

//		synchronized (MyTest.class) {
//			
//		myTest.start();
//
//		myTest2.start();
//		}
//
//		// System.out.println("hello##################################################################");
//		System.out.println("Going to sleep");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Awake");
		
		Thread thread1 = new Thread(new Runner());
		thread1.start(); 

	}

}

class Runner implements Runnable {

	@Override
	public void run() {
		
		for (int i = 1; i < 31; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello from thread  " + i);
		}

	}

}

class MyTest extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < 30; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello from thread  " + i);
		}

	}

}
