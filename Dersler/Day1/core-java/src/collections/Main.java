package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int - Integer

		int a = 5;

		Integer b = 5;

		Integer age = new Integer(a);

		// Wrapper class - Integer Boolean Long Character

		int[] intArray = { 1, 2, 3, 4 };

		String[] intArray1 = { "cem", "patika.dev" };

		int[] intArray2 = new int[4];
		intArray2[0] = 1;
		intArray2[1] = 1;
		intArray2[2] = 1;
		intArray2[3] = 1;
		// intArray2[4]=1;

		Boolean[] booleanList2 = new Boolean[5];

		System.out.println("size: " + intArray2.length);
		long a1 = 56;

		// List<int> intList;

		List<Integer> intList = null; // Generics

		List<Boolean> booleanList;

		List<String> stringList;

		List<Long> longList;

		LinkedList<Character> characters;

		// intList.add(age);

		List<Integer> ageList = new ArrayList<>(); // default 10 adet size

		ageList.add(age);
		ageList.add(age + 3);
		ageList.add(age + 6);
		ageList.add(age + 7);
		ageList.add(age + 8);
		ageList.add(age + 9);
		ageList.add(age + 10);
		ageList.add(age + 15);

		List<Integer> intList2 = new ArrayList<>(10000);

		ArrayList<Integer> intList3 = new ArrayList<>(10000);

		Set<Integer> set = new HashSet<>();

		Set<Integer> treeSet = new TreeSet<>();

		Map<Integer, String> map = new HashMap<Integer, String>();

		Map<Integer, List<String>> map1 = new HashMap<>();

		Map<Integer, Map<Integer, String>> map2 = new HashMap<>();

		System.out.println("stream");

		ageList.stream().forEach(System.out::println);

		// kara düzen
		for (Integer age1 : ageList) {
			System.out.println(age1);
		}

		// --
		System.out.println("stream ile filtreleme");

		List<Integer> newAgeList = ageList.stream().filter(it -> it > 8).filter(it -> it < 15).toList();

		ageList.stream().filter(it -> it > 8).filter(it -> it < 15).forEach(System.out::println);

		newAgeList.stream().forEach(it -> {
			// method call
			if (true) {

			}
		});
		
		
		Set<String> namesSet = new HashSet<>(Arrays.asList("patika", "dev", "java"));

		namesSet.forEach(System.out::println);
		
		System.out.println("filtering");
		
		namesSet.stream().filter(it -> it.contains("a")).toList();
		namesSet.stream().filter(it -> it.contains("a")).forEach(System.out::println);
		namesSet.stream()
		.filter(it -> it.contains("a"))
		.forEach(System.out::println);
		
		
		System.out.println("");
		
		Map<Integer, String> namesMap = new HashMap<>();
		namesMap.put(1, "patika");
		namesMap.put(2, "dev");
		namesMap.put(3, "java");

		namesMap.forEach((key, value) -> System.out.println(key + " " + value));
		
		
		
		
		
	}
	


}
