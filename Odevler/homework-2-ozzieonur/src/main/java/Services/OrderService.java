package Services;
import Models.Company;
import Models.ICustomer;
import Models.Order;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {
    static Set<Order> orderList = new HashSet<>();


    public OrderService() {}

    public void addOrder(Order order, ICustomer customer, Company company) {
        orderList.add(order);
        customer.getOrderList().add(order);
        company.getCompanyOrderList().add(order);

    }

    public void findOrdersByCustomer(int customerId){
        System.out.println("Müşteri: " + CustomerService.getCustomerNameById(customerId));
        orderList.stream()
                .filter(c-> c.getCustomerId() == customerId).map(c ->
                " | Tutar: "+c.getTotalAmount())
                .forEach(System.out::println);
    }

    public void getAllOrders(){
        orderList.stream().map(c -> c.getId() + " "+ " | Müşteri: " + CustomerService.getCustomerNameById(c.getCustomerId()) + " | Tutar: " + c.getTotalAmount())
        .forEach(System.out::println);
    }

    public void getSumAmount(String month) {
        List<ICustomer> list =  CustomerService.getFilteredCustomersByMonth(month);
        Double sum = list.stream().mapToDouble(customer -> customer.getOrderList().stream().mapToDouble(Order::getTotalAmount).sum()).sum();

        System.out.println(sum);


    }

    public void getOrdersGreaterThanValue(Double value){
        orderList.stream().filter(order -> order.getTotalAmount() > value)
                .map(order -> " | Müşteri: " + CustomerService.getCustomerNameById(order.getCustomerId()) + " | Fatura Tutarı: " + order.getTotalAmount())
                .forEach(System.out::println);
    }

    public void getAverageOfOrderGreaterThanValue(Double value){
       System.out.println(orderList.stream().filter(order -> order.getTotalAmount() > value).mapToDouble(Order::getTotalAmount).average().getAsDouble());

    }

    public void getCustomerNameWithOrderByLesserThanValue(Double value){
       List<String> list = orderList.stream().filter(order -> order.getTotalAmount() < value)
               .map(order -> " | "+ CustomerService.getCustomerNameById(order.getCustomerId()))
               .collect(Collectors.toList());
       Set<String> settingOrderList = new HashSet<String>(list);
       settingOrderList.forEach(System.out::println);
    }

    public void getOrdersFromOneCustomer(ICustomer customer) {
        customer.getOrderList().stream().map(order -> order.getDescription() + " || " + order.getTotalAmount() + " TL || " + order.getMonth()).forEach(System.out::println);
    }



    public static void getAverageOfOrdersFromOneCompany(Company company, Double value, String month) {
        if(company.getCompanyOrderList().stream().filter(order -> order.getMonth().equals(month))
                .mapToDouble(order -> order.getTotalAmount()).average().getAsDouble() < value) {
             System.out.println(company.getSector());
        }

    }
}
