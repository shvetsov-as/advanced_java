package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableTest {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);

		Iterator<Integer> iterator = list.iterator();
		
		int count = 0;
		while (iterator.hasNext()) {
			
			System.out.println(iterator.next());
			
			if(count == 1) {
			iterator.remove();	
			}
			
			
			count++;
		}

		for (Integer x : list)
			System.out.println(x);

	}

}
