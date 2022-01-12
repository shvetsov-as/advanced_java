package regExp;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

	public static void main(String[] args) {

		String text = "Hello. Guys! I send you my email joe@gmail.com so we can\n"
				+ "keep in touch, Thanks, Joe! Thats's cool. I am sending you\n"
				+ "my address: tim@yandex.ru. Let's stay in touch...";

		Pattern email = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");

		Matcher matcher = email.matcher(text);

		while (matcher.find()) {
			System.out.println(matcher.group(3));

		}

		String s;
		s = "Тестовая строка, используемая для разложения на слова";
		StringTokenizer st = new StringTokenizer(s, " \t\n\r,.");
		while (st.hasMoreTokens()) {
			// Выводим лексемы в консоль
			System.out.println(st.nextToken());
		}

	}
}
