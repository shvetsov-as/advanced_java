package annotations;

public class Test {

	@MethodInfo(author = "Alex", dateOfCreation = 2021, purpose = "Print hello world")
	// if @MethodInfo(purpose = "Print hello world" )
	// author and dateOfCreation will be default
	
	public void printHelloWorld() {
		System.out.println("Hello world!");
	}

}
