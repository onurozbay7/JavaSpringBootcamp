package Services;

import Models.CustomerFactory;
import Models.ICustomer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CustomerService { // Singleton Pattern prensibine uygun hale çevrildi.

    private static CustomerService customerService = null;

    static List<ICustomer> customerList = new ArrayList<>();


    protected CustomerService() {
        ICustomer customer = CustomerFactory.createCustomer("Individual","Onur Özbay",24,"Haziran");
        ICustomer customer1 = CustomerFactory.createCustomer("Corparate","Ufuk Can Kurt",23,"Haziran");
        ICustomer customer2 = CustomerFactory.createCustomer("Individual","Berkan Ek",23,"Haziran");
        ICustomer customer3 = CustomerFactory.createCustomer("Corparate","Ömercan Yılmaz",24,"Mayıs");
        ICustomer customer4 = CustomerFactory.createCustomer("Individual","Umut Samsum",24,"Temmuz");
        customerList.add(customer);
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
    }

    private synchronized static void createInstance(){
        if (customerService == null) {
            customerService = new CustomerService();
        }

    }

    public static CustomerService getInstance(){
        if (customerService == null) createInstance();
        return customerService;
    }

    public void addCustomer(ICustomer customer){
        customerList.add(customer);
    }

    public void getAllCustomers(){
        customerList.stream().map(customer -> customer.getId() + " | " +customer.getFullName()).forEach(System.out::println);
    }

    public void getFilteredCustomersByLetter(String letter){
        customerList.stream()
                .map(customer -> customer.getId() + " | " +customer.getFullName())
                .filter(c -> (c.contains(letter.toLowerCase()) || (c.contains(letter.toUpperCase()))))
                .forEach(System.out::println);
    }

    public static List<ICustomer> getFilteredCustomersByMonth(String month) {

       return customerList.stream()
                .filter(customer -> customer.getDateOfReg()
                .equals(month)).collect(Collectors.toList());

    }

    public static String getCustomerNameById(int customerId){
        return customerList.stream().filter(c -> c.getId() == customerId).map(ICustomer::getFullName).collect(Collectors.joining());
    }











}
