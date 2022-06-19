package oop;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student student = new Student();
		student.name = "umutcan";

		System.out.println("student:" + student.clazz);

		Student student1 = new Student("müjdat");

		System.out.println("student1:" + student1.clazz);

		System.out.println("Student:" + Student.clazz);

		int clazz = Student.clazz;

		//
		// Person.LENGTH = 10;

		// kalıtım
		// polimorfizm --> çok biçimlilik
		// encaplusation

		Student student2 = new Student();
		student2.name = "name";
		student2.surname = "surname";
		student2.walk();

		Person student3 = new Student("örnek öğrenci");
		student3.walk();

		((Student) student3).name = "student3";
		((Student) student3).walk();
		
		
		

	}

}
