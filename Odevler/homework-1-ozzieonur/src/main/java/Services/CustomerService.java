package Services;

import Models.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class CustomerService {

    static List<Customer> customerList = new ArrayList<>();


    public CustomerService() {
        Customer customer = new Customer("Murat Tanrıverdi", 24, "Haziran");
        Customer customer1 = new Customer("Ufuk Can Kurt", 23, "Haziran");
        Customer customer2 = new Customer("Berkan Ek", 23, "Haziran");
        Customer customer3 = new Customer("Ömercan Yılmaz", 24, "Mayıs");
        Customer customer4 = new Customer("Umut Samsum", 24, "Temmuz");
        customerList.add(customer);
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void getAllCustomers() {
        customerList.stream().map(customer -> customer.getId() + " | " + customer.getFullName()).forEach(System.out::println);
    }

    public void getFilteredCustomersByLetter(String letter) {
        customerList.stream()
                .map(customer -> customer.getId() + " | " + customer.getFullName())
                .filter(c -> (c.contains(letter.toLowerCase()) || (c.contains(letter.toUpperCase()))))
                .forEach(System.out::println);
    }

    public static List<Customer> getFilteredCustomersByMonth(String month) {

        return customerList.stream()
                .filter(customer -> customer.getDateOfReg()
                        .equals(month)).collect(Collectors.toList());
    }

    public static String getCustomerNameById(int customerId) {
        return customerList.stream().filter(c -> c.getId() == customerId).map(Customer::getFullName).collect(Collectors.joining());
    }


}
