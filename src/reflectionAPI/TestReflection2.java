package reflectionAPI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try {

			// ClassName1, ClassName2, MethodName;
			// scanner.next() - divide input(console) string by " ";
			Class<?> classObject1 = Class.forName(scanner.next());
			Class<?> classObject2 = Class.forName(scanner.next());
			String methodName = scanner.next();

			// На объекте класса 1 classObject1 вызывается метод getMethod, в
			// аргументы
			// которому передается имя вызываемого метода из класса 1
			// classObject1 и аргумент, который является экземпляром класса 2
			// classObject2
			Method m = classObject1.getMethod(methodName, classObject2);

			// По полученному имени класса classObject1 =
			// Class.forName(scanner.next()); будет создан новый объект с пустым
			// конструктором и помещен в o1
			Object o1 = classObject1.getDeclaredConstructor().newInstance();

			// создаем из конструктора, принимающего строковое значение
			Object o2 = classObject2.getConstructor(String.class)
					.newInstance("String value");

			m.invoke(o1, o2);// invoke - вызывает метод у o1 c аргументом o2

			System.out.println(o1);
			
			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//input parameters [ reflectionAPI.Person java.lang.String setName ]
	}

}
