package multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiCallableFuture {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(1);

		Future<Integer> future = executorService
				.submit(new Callable<Integer>() {

					@Override
					public Integer call() throws Exception {

						System.out.println("Starting...");

						Thread.sleep(500);

						System.out.println("Finished...");

						Random random = new Random();
						int randomValue = random.nextInt(10);
						
						if(randomValue < 10) {
							throw new Exception("Something went wrong... ExecutionException...");
						}

						return randomValue;
					}
				});

		executorService.shutdown();

		try {

			int result = future.get();// will wait the end of our thread, then
										// give us the result
			System.out.println(result);

		} catch (InterruptedException | ExecutionException e) {
			
			//System.out.println("Exception " + e.getMessage());
			
			Throwable ex = e.getCause();
			System.out.println(ex.getMessage());
		}

	}

}
