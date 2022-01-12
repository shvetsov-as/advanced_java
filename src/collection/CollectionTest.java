package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class CollectionTest {

	public static void main(String[] args) {

		List<String> animals = new ArrayList<>();

		animals.add("dog");
		animals.add("cat2");
		animals.add("frog1");
		animals.add("bird23");
		animals.add("elephant");
		animals.add("ca");

		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length())
					return 1;
				if (o1.length() < o2.length())
					return -1;
				return 0;
			}
		};

		Collections.sort(animals, comp);
		System.out.println(animals);

		List<Integer> numbers = new ArrayList<>();

		numbers.add(41);
		numbers.add(15);
		numbers.add(73);
		numbers.add(46);
		numbers.add(95);
		numbers.add(16);

		Collections.sort(numbers, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2)
					return -1;
				if (o1 < o2)
					return 1;
				return 0;
			}
		});
		
		Collections.sort(numbers, (o1, o2) -> {
				if (o1 > o2)
					return -1;
				if (o1 < o2)
					return 1;
				return 0;
			
		});
		
		

		System.out.println(numbers);

		List<Person> people = new ArrayList<Person>();

		people.add(new Person(2, "Katy"));
		people.add(new Person(4, "Egor"));
		people.add(new Person(1, "Bob"));
		people.add(new Person(3, "Mike"));

		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.getId() > o2.getId()) {
					return 1;
				} else if (o1.getId() < o2.getId()) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		System.out.println(people);
	}


}

class Person {
	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
