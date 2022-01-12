package regExp;

import java.util.Arrays;

public class RegTest1 {
	public static void main(String[] args) {

		
		 // \\d - one digit
		 // \\w - one letter
		 // \\w = [a-zA-Z]
		  
		 // + - 1 or more;
		 // - 0 or more;
		 // ? - 0 or 1 symbols before;
		 // . - any symbol;

		 // the exact number of previous symbols
		 // {2} - two symbols before (\\d{2}) - only two digits in this place
		 // {2,} - from two symbols - two or more (\\d{2,}) - from two till infinity digits in this place
		 // {2, 4} - from two to four symbols - two or three or four (\\d{2, 4}) - from two to four digits in this place
		  
		 // (x|y|z) - verojatnosti libo x, libo y, libo z
		 // 
		 // [a-zA-Z] - all symbols that can be in our String
		 
		 // [abc] = (a|b|c)
		 
		 // [^abc] - all but [abc] 
		 
		 // [^a-z] - all English letters but [a-z] in lower case
		 
		 // [0-9] = \\d
		 
		

		String a = "43434";
		String b = "-343434";
		String c = "+343434";
		String d = "d9797";
		String e = "dsrrere9797";
		String f = "dsr3434rere9797";
		String g = "dsr11113333rere9797";
		String h = "hello";
		String i = "asdf";
		String url = "http://www.google.com";
		String url2 = "http://helloThere";
		String j = "123";
		
		String k = "Hello.there.hey";
		String l = "Hello745575there575676hey";
		
		String m = "Hello there hey";
		String n = "Hello5345245234there57896895673563353423hey";
		String o = "Hello5345245234there57896895673563353423hey";
		
		String[] words = k.split("\\.");
		System.out.println(Arrays.toString(words));
		
		String[] words2 = l.split("\\d+");
		System.out.println(Arrays.toString(words2));
		
		String words3 = m.replace(" ", "...");
		System.out.println(words3);
		
		String words4 = n.replaceAll("\\d+", "..."); //replaceAll's input takes a regExp as first argument
		System.out.println(words4);
		
		String words5 = o.replaceFirst("\\d+", "..."); //replaceFirst changes the first match of regExp 
		System.out.println(words5);

		
		System.out.println(a.matches("-?\\d*")); // matches + or - any number
													// of digits
		System.out.println(b.matches("-?\\d*")); // 0 ili 1 minusov v nashey
													// stroke lubogo kolichestva
													// chisel
		System.out.println(c.matches("(-|\\+)?\\d*"));
		System.out.println(d.matches("[a-zA-Z]\\d+"));
		System.out.println(e.matches("[a-zA-Z]+\\d+"));
		System.out.println(f.matches("[a-zA-Z0-9]+\\d+"));
		System.out.println(g.matches("[a-zA-Z13]+\\d+"));
		System.out.println(match(h, "[^abc]*"));
		
		System.out.println(match(i, "[^abc]*"));//FALSE----------
		
		System.out.println(match(url, "http://www\\..+\\.(com|ru)")); //.+ - any number of symbols
		
		System.out.println(match(url2, "http://www\\..+\\.(com|ru)"));//FALSE----------
		
		System.out.println(match(j, "\\d{2}")); //FALSE----------
		
		System.out.println(match(j, "\\d{2,}"));
		System.out.println(match(j, "\\d{3}"));
		

	}

	static boolean match(String str, String regExp) {
		if (str.matches(regExp)) {
			return true;
		}
		return false;
	}
}
