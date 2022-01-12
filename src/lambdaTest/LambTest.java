package lambdaTest;


@FunctionalInterface
interface Executable {
	int execute(int x, int y);
}

class Runner {

	public void run(Executable e) {
		int a = e.execute(10, 15);
		System.out.println(a);

	}
}

public class LambTest {

	public static void main(String[] args) {

		Runner runner = new Runner();

		runner.run(new Executable() {
			@Override
			public int execute(int x, int y) {
				System.out.println("runner.run(new Executable())");
				return x + y;

			}

		});

		runner.run((int x, int y) -> {
			System.out.println("Lambda hello");
			System.out.println("Lambda hello again");
			return x + y;
		});

		runner.run((x, y) -> x + y);


	}

}
