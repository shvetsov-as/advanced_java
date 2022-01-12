package reflectionAPI;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {

	public static void main(String[] args) {

		Person person = new Person();

		Class<Person> personClass = Person.class;
		Class<? extends Person> personClass2 = person.getClass();

		try {
			Class<?> personClass3 = Class.forName("reflectionAPI.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Method[] methods = personClass.getMethods();

		Arrays.stream(methods)
				.forEach(method -> System.out.println("Method name: "
						+ method.getName() + "\n\t return type: "
						+ method.getReturnType() + "\n\t input parameters: "
						+ Arrays.toString(method.getParameterTypes())));

		Field[] fields = personClass2.getDeclaredFields();
		Arrays.stream(fields).forEach(field -> System.out.println("Field name: "
				+ field.getName() + "\n\t Field type: " + field.getType()));
		
		Annotation[] annotations = personClass2.getAnnotations();
		Arrays.stream(annotations).forEach(annotation -> {
			if(annotation instanceof Author) {
				System.out.println("Annotation is Author");
			}
			});

	}

}
