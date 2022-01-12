package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {

		List<Integer> linkedList = new LinkedList<>();
		List<Integer> arrayList = new ArrayList<>();

		//measureTime(linkedList, "linkedList");
		//measureTime(arrayList, "arrayList");
		
		MyLinkedList myLinkedList = new MyLinkedList();
		
		for (int i = 1; i < 5; i++) {
			
			myLinkedList.add(i);
		}
		System.out.println(myLinkedList);
		myLinkedList.remove(0);
		//System.out.println(myLinkedList.get(0));
		//System.out.println(myLinkedList.get(1));
		//System.out.println(myLinkedList.get(2));
		System.out.println(myLinkedList);

	}

	/*
	 * private static void measureTime (List<Integer> list) { long start =
	 * System.currentTimeMillis();
	 * 
	 * 
	 * for (int i = 0; i < 10000000; i++) { list.add(i); }
	 * 
	 * 
	 * long end = System.currentTimeMillis(); long res = end - start;
	 * System.out.println("time of operation  = " + res); }
	 */

	/*
	 * private static void measureTime(List<Integer> list) {
	 * 
	 * for (int i = 0; i < 100000; i++) { list.add(i); }
	 * 
	 * long start = System.currentTimeMillis();
	 * 
	 * for (int i = 0; i < 100000; i++) { list.get(i); }
	 * 
	 * long end = System.currentTimeMillis(); long res = end - start;
	 * System.out.println("time of operation  = " + res); }
	 */
	
	private static void measureTime(List<Integer> list, String name) {

		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 100000; i++) {
			list.add(0, i); //add element to start of list
		}
		
		long end = System.currentTimeMillis();
		
		
		long res = end - start;
		System.out.println("time of operation for " + name + " = " + res);
	}
}
