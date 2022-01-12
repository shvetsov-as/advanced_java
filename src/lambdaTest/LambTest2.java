package lambdaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LambTest2 {
	public static void main(String[] args) {

		int[] arr1 = new int[10];
		List<Integer> list1 = new ArrayList<>();

		fillArr(arr1);
		fillList(list1);

		// System.out.println(list1);
		// System.out.println(Arrays.toString(arr1));
		// for (int i = 0; i < 10; i++) {
		// arr1[i] = arr1[i] * 2;
		// list1.set(i, list1.get(i) * 2);
		// }

		// map method

		arr1 = Arrays.stream(arr1).map(a -> a * 2).toArray();
		list1 = list1.stream().map(a -> a * 2).collect(Collectors.toList());

		arr1 = Arrays.stream(arr1).map(a -> 3).toArray();
		arr1 = Arrays.stream(arr1).map(a -> a + 1).toArray();

		System.out.println(list1);
		System.out.println(Arrays.toString(arr1));

		// filter method

		int[] arr2 = new int[10];
		List<Integer> list2 = new ArrayList<>();

		fillArr(arr2);
		fillList(list2);

		arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
		list2 = list2.stream().filter(a -> a % 2 == 0)
				.collect(Collectors.toList());

		System.out.println(list2);
		System.out.println(Arrays.toString(arr2));

		// forEach

		Arrays.stream(arr2).forEach(System.out::println);
		list2.stream().forEach(a -> System.out.println(a));

		// reduce

		int[] arr3 = new int[10];
		List<Integer> list3 = new ArrayList<>();

		fillArr(arr3);
		fillList(list3);

		int sumAllelements = Arrays.stream(arr3).reduce(
				(accumulator, tekyshiyElement) -> accumulator + tekyshiyElement)
				.getAsInt();

		int sumAllelements2 = Arrays.stream(arr3).reduce(0, (accumulator,
				tekyshiyElement) -> accumulator + tekyshiyElement);// 0 -
																	// accumulator
																	// start
																	// value
																	// (default
																	// - first
																	// element
																	// of
																	// array).
																	// .getAsInt()
																	// - not
																	// needed

		// esli nachalnoe znachenie accuma ne ykazno, to ono = pervomu elementy,
		// a iteraciya nachanaetsa so 2 elementa
		Integer sumAllListElements = list3.stream().reduce(
				(accumulator, tekyshiyElement) -> accumulator + tekyshiyElement)
				.get();

		System.out.println(sumAllListElements);
		System.out.println(sumAllelements);
		System.out.println(sumAllelements2);

		int[] arr4 = new int[10];

		fillArr(arr4);

		int[] newArray = Arrays.stream(arr4).filter(a -> a % 2 != 0)
				.map(a -> a * 2).toArray();
		System.out.println(Arrays.toString(newArray));

		Set<Integer> set = new HashSet<>();
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		System.out.println(set);
		set = set.stream().map(a -> a * 3).collect(Collectors.toSet());
		System.out.println(set);
	}

	private static void fillArr(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}

	}

	private static void fillList(List<Integer> list) {

		for (int i = 0; i < 10; i++) {
			list.add(i + 1);
		}

	}

}
