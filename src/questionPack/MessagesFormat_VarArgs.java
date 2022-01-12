package questionPack;

import java.text.MessageFormat;
import java.util.Date;

public class MessagesFormat_VarArgs {

	public static void main(String[] args) {

		Object[] arguments = {new Integer(7), new Date(),
				"a disturbance in the Force"};

		String result = MessageFormat
				.format("At {1,time} on {1,date}, there was {2} on planet "
						+ "{0,number,integer}.", arguments);

		System.out.println(result);

		Object[] arguments2 = {new Integer[7], new Date(),
				"a disturbance in the Force"};

		String result2 = MessageFormat.format(
				"At {1,time} on {1,date}, there was {2} on planet "
						+ "{0,number,integer}.",
				7, new Date(), "a disturbance in the Force");

		System.out.println(result2);

		shoppingList("milk", "potato", "again milk", "coca-cola", "bread",
				"corn flakes");

	}

	private static void shoppingList(String... items) {
		System.out.println("-----Shopping list-----");
		for (int i = 0; i < items.length; i++) {
			System.out.println(i + 1 + ": " + items[i]);
		}

	}
}
