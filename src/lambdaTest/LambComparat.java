package lambdaTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambComparat {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("Goodbye");
		list.add("a");
		list.add("ad");

		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length())
					return 1;
				else if (o1.length() < o2.length())
					return -1;
				else
					return 0;
			}
		});
		System.out.println(list);

		list.sort((str1, str2) -> {
			if (str1.length() > str2.length())
				return 1;
			else if (str1.length() < str2.length())
				return -1;
			else
				return 0;
		});

		System.out.println(list);

		Comparator<String> comparator = ((str1, str2) -> {
			if (str1.length() > str2.length())
				return 1;
			else if (str1.length() < str2.length())
				return -1;
			else
				return 0;
		});

		list.sort(comparator);

		System.out.println(list);
	}
}
