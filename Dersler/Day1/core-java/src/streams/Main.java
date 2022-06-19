package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();

		List<Customer> customers = customerService.prepareCustomerList();

		Stream<Customer> customerStream = Stream.of(new Customer("bilisim.io", 5, new ArrayList<Order>()));

		List<Integer> ageList = new ArrayList<>();

		ageList.add(25);
		ageList.add(28);
		ageList.add(15);
		ageList.add(35);
		ageList.add(45);
		ageList.add(20);

		ageList.forEach(System.out::println);

		ageList.stream().filter(age -> age > 35).forEach(System.out::println);

		ageList.stream().filter(age -> age > 35).toList();

		for (Integer age : ageList) {
			if (age > 35) {
				System.out.println(age);
			}
		}

		customers.stream().forEach(customer -> {
			customer.age += 3;
		});

		customers.stream().forEach(customer -> customer.age += 3);

		customers.stream().forEach(CustomerService::incrementCustomerAge);

		List<String> customerNames = customers.stream().map(customer -> customer.name)
				.filter(customerName -> customerName.startsWith("c")).toList();

		customerNames.forEach(System.out::println);

		Set<String> customerNamesSet = customers.stream().map(customer -> customer.name)
				.filter(customerName -> customerName.startsWith("c")).collect(Collectors.toSet());

		List<String> customerNamesList = customers.stream().map(customer -> customer.name)
				.filter(customerName -> customerName.startsWith("c")).collect(Collectors.toList());

		Map<String, Integer> customerNamesMap = customers.stream().filter(customer -> customer.age > 35)
				.filter(customer -> customer.name.startsWith("c"))
				.collect(Collectors.toMap(Customer::getName, Customer::getAge));

		List<String> collect = customers.stream().filter(customer -> customer.age > 18)
				.peek(CustomerService::incrementCustomerAge).map(customer -> customer.name)
				.peek(customerName -> customerName = customerName.trim())
				.filter(customerName -> customerName.startsWith("c"))
				.peek(customerName -> customerName = customerName.replace("c", "C"))

				.collect(Collectors.toList());

		Customer firstCustomer = customers.stream().filter(customer -> customer.age > 18)
				.peek(CustomerService::incrementCustomerAge).findFirst()
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		int maxAge = customers.stream().map(Customer::getAge).reduce(0, Math::max).intValue();

		System.out.println("max age: " + maxAge);

	}

}
