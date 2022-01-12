package lambdaTest;

import java.util.StringJoiner;

@FunctionalInterface
interface ImyInter {
	String getAnswer(String strPart1, String strPart2);
}

class Testclass {

	String strTest1 = "hello";
	String strTest2 = "world";

	public String answer(ImyInter e) {
		System.out.println("OUTPUT IN class Testclass");
		return e.getAnswer(strTest1, strTest2);
	}

}

public class LambdaTest3 {

	public static void main(String[] args) {

		Testclass test = new Testclass();

		ImyInter ref;
		ref = (strTest1, strTest2) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(strTest1);
			sb.append(" ");
			sb.append(strTest2);
			String res = sb.toString();
			sb.delete(0, res.length());

			for (int i = res.length() - 1; i >= 0; i--) {
				sb.append(res.charAt(i));
			}
			return sb.toString();

		};

		System.out.println(test.answer(ref));

		System.out.println(test.answer((a, b) -> {
			StringBuilder sb = new StringBuilder();

			sb.append(a);
			sb.append(" ");
			sb.append(b);
			return sb.toString();
		}));

		String s = test.answer((a, b) -> {
			StringJoiner sj = new StringJoiner(", ", "StringJoiner[ ",
					" ]StringJoiner");
			// String st1 = "hello1";
			// String st2 = "world1";
			sj.add(a);
			sj.add(b);
			return sj.toString();
		});

		System.out.println(s);

	}

}
