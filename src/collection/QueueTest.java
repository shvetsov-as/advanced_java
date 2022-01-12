package collection;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {

	public static void main(String[] args) {

		PersonQ person1 = new PersonQ(1);
		PersonQ person2 = new PersonQ(2);
		PersonQ person3 = new PersonQ(3);
		PersonQ person4 = new PersonQ(4);
		PersonQ person5 = new PersonQ(5);

//		Queue<PersonQ> people = new LinkedList<>();
//		
//		people.add(person3);
//		people.add(person2);
//		people.add(person4);
//		people.add(person1);
//		people.add(person5);
//
//		for(PersonQ person : people) {
//			System.out.println(person);
//		}

		Queue<PersonQ> people = new ArrayBlockingQueue<PersonQ>(4);

//		people.add(person3);
//		people.add(person2);
//		people.add(person4);
//		people.add(person1);
//		people.add(person5);

		System.out.println(people.offer(person3));
		System.out.println(people.offer(person2));
		System.out.println(people.offer(person4));
		System.out.println(people.offer(person1));
		System.out.println(people.offer(person5));

//		System.out.println(people.remove());
//		System.out.println(people.peek());
//		System.out.println(people);

//		for (PersonQ person : people) {
//			System.out.println(person);
//		}
	}

}

class PersonQ {
	private int id;

	public PersonQ(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PersonQ [id = " + id + " ]";
	}

}
