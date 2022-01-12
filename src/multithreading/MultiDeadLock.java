package multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiDeadLock {

	public static void main(String[] args) {

		TestRunner runner = new TestRunner();

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.secondTherad();
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

		runner.finished();

	}

}
class TestRunner {

	private Account account1 = new Account();
	private Account account2 = new Account();

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	private void takeLocks(Lock lock1, Lock lock2) throws InterruptedException {

		boolean firstLockTaken = false;
		boolean secondLockTaken = false;
		while (true) {
			try {
				firstLockTaken = lock1.tryLock();
				secondLockTaken = lock2.tryLock();
			} finally {
				if (firstLockTaken && secondLockTaken) {
					return;
				}
				if (firstLockTaken) {
					lock1.unlock();
					System.out.println("deadlock 1");
				}
				if (secondLockTaken) {
					lock2.unlock();
					System.out.println("deadlock 2");
				}
			}
			Thread.sleep(1);
		}
	}

	public void firstThread() throws InterruptedException {

		Random random = new Random();
		// synchronized (Account.class) {}
		for (int i = 0; i < 10000; i++) {

			takeLocks(lock1, lock2);

			try {
				Account.transfer(account1, account2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondTherad() throws InterruptedException {

		Random random = new Random();
		// synchronized (Account.class) {}
		for (int i = 0; i < 10000; i++) {
			takeLocks(lock2, lock1);

			try {
				Account.transfer(account2, account1, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void finished() {
		System.out.println("First Acc balance is " + account1.getBalance());
		System.out.println("Second Acc balance is " + account2.getBalance());
		System.out.println("Total balance (both Acc) is "
				+ (account1.getBalance() + account2.getBalance()));

	}
}

class Account {

	private int balance = 10000;

	public static void transfer(Account acc1, Account acc2, int amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public int getBalance() {
		return balance;
	}

}