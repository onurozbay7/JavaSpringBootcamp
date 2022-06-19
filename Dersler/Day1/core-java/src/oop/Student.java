package oop;

public class Student extends Object implements Person {

	public String name;
	protected String surname;

	static int clazz = 1;

	public Student() {

	}

	protected Student(String name) {
		super();
		this.name = name;
	}

	public Student(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

//	@Override
//	public void walk() {
//		System.out.println("Student - walk");
//	}

	@Override
	public void walk(int a) {
		System.out.println("Student - walk");

	}

	@Override
	public int walk(int a, String b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
