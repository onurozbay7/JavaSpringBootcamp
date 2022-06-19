package oop;

public interface Person {
	
	
	int LENGTH = 10;

	void walk(int a); // method signature

	int walk(int a, String b);
	
	default void walk() {
		// do something
		System.out.println("Person - walk");
	}

}
