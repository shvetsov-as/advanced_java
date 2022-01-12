package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class CollectionNaturalOrder {

	public static void main(String[] args) {

		List<Person1> peopleList = new ArrayList<Person1>();
		Set<Person1> peopleSet = new TreeSet<>();
Object l = new Object();
System.out.println(l.getClass().getDeclaredFields());
		addElement(peopleList);
		addElement(peopleSet);

		System.out.println(peopleList);
		System.out.println(peopleSet);
		
		Collections.sort(peopleList);
		System.out.println(peopleList);
		
		Person1 pers = new Person1(1, "sd");
		if(pers instanceof Person1) {
			System.out.println("alskdaslkdjalsjd");
		}
		

	}

	private static void addElement(Collection<Person1> collection) {
		collection.add(new Person1(3, "Mikelindionisa"));
		collection.add(new Person1(1, "Bob"));
		collection.add(new Person1(4, "Egor"));
		collection.add(new Person1(2, "Katysha"));
		collection.add(new Person1(7, "Cheburator"));
	}

}

class Person1 implements Comparable<Person1> {
	private int id;
	private String name;

	public Person1(int id, String name) {
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
		Person1 other = (Person1) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Person1 o) {
		if (this.name.length() > o.getName().length()) {
			return 1;
		} else if (this.name.length() < o.getName().length()) {
			return -1;
		} else {
			return 0;
		}

	}

}
