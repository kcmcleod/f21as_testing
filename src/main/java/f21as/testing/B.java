package f21as.testing;

// This is a basic POJO
// To generate a unit test for this class (in Eclipse):
// 1. Right click the class in the Package Explorer
// 2. Choose New > JUnit Test Case
// 3. Change Source folder to TestingLC/src/test/java
// 4. Click Finish
//
public class B {
	private int number = 0;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if (number < 0) throw new IllegalArgumentException("Value of number must be 0 or more"); 
		this.number = number;
	}
	
	// Test Driven Design
	// 1. Take the spec from UML
	// 2. Write the tests
	// 3. Add enough code in the method below to make 1 test pass
	// 4. Repeat until all tests pass 
	public String processNumber() {
		// return "small number" if number < 10
		// return "medium number" if number < 100
		// return "large number" if 100 < number
		return "";
	}
}
