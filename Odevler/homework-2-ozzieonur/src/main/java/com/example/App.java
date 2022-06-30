package com.example;

import Models.*;
import Services.CompanyService;
import Services.CustomerService;
import Services.OrderService;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
// ---------------------------------------------------------------------------------------------------------------------- //
        CustomerService customerService = CustomerService.getInstance(); // Singleton Prensibi

        ICustomer customer = CustomerFactory.createCustomer("Individual","Onur Özbay",24,"Haziran");
        ICustomer customer1 = CustomerFactory.createCustomer("Corparate","Aytaç Özbay",24,"Temmuz");
        ICustomer customer2 = CustomerFactory.createCustomer("Individual","Altay Şimşek",24,"Ağustos");
        ICustomer customer3 = CustomerFactory.createCustomer("Corparate","Ali Keskin",24,"Ağustos");
        ICustomer customer4 = CustomerFactory.createCustomer("Corparate","Hüseyin Altun",21,"Eylül");


        customer.showCustomerInfo();
        customer1.showCustomerInfo();
        customer2.showCustomerInfo();
        System.out.println("*******************************************************************************");

        customerService.addCustomer(customer);
        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);
        customerService.addCustomer(customer3);
        customerService.addCustomer(customer4);

// ---------------------------------------------------------------------------------------------------------------------- //
        CompanyService companyService = new CompanyService();
        Company company = new Company("Teksöz1","Bilişim", "hello1");
        Company company1 = new Company("Horoz","Kırtasiye", "hello2");
        Company company2 = new Company("Migros","Gıda", "hello3");
        Company company3 = new Company("Migros","Eğlence", "hello3");

        companyService.addCompany(company);
        companyService.addCompany(company1);
        companyService.addCompany(company2);
        companyService.addCompany(company3);



// ---------------------------------------------------------------------------------------------------------------------- //
        OrderService orderService = new OrderService();
        Order order = new Order(customer.getId(),company.getId(),"Musluk alındı.","Haziran",1500);
        Order order2 = new Order(customer.getId(),company.getId(),"Boya alındı.","Temmuz",3000);
        Order order3 = new Order(customer1.getId(),company2.getId(),"Yemek alındı.","Haziran",4000);
        Order order4 = new Order(customer3.getId(),company1.getId(),"Buzdolabı alındı.","Haziran",2000);
        Order order5 = new Order(customer.getId(),company.getId(),"Süpürge alındı.","Haziran",200);
        Order order6 = new Order(customer.getId(),company1.getId(),"Makas alındı.","Eylül",100);
        Order order7 = new Order(customer3.getId(),company.getId(),"Kalem alındı.","Haziran",50);
        Order order8 = new Order(customer3.getId(),company2.getId(),"Kalem alındı.","Haziran",50);
        Order order9 = new Order(customer1.getId(),company.getId(),"Yemek alındı.","Haziran",4000);
        Order order10 = new Order(customer4.getId(),company2.getId(),"Yemek alındı.","Haziran",7000);
        Order order11 = new Order(customer4.getId(),company3.getId(),"Yemek alındı.","Haziran",50);
        Order order12 = new Order(customer4.getId(),company3.getId(),"Yemek alındı.","Haziran",1000);
        Order order13 = new Order(customer4.getId(),company3.getId(),"Yemek alındı.","Haziran",1000);

        orderService.addOrder(order,customer,company);
        orderService.addOrder(order2,customer,company);
        orderService.addOrder(order3,customer1,company2);
        orderService.addOrder(order4,customer3,company1);
        orderService.addOrder(order5,customer,company);
        orderService.addOrder(order6,customer,company1);
        orderService.addOrder(order7,customer3,company);
        orderService.addOrder(order8,customer3,company2);
        orderService.addOrder(order10,customer4,company2);
        orderService.addOrder(order9,customer3,company);
        orderService.addOrder(order9,customer3,company); // Set olduğu için birdaha eklenemiyor.

        orderService.addOrder(order11,customer3,company3);
        orderService.addOrder(order12,customer3,company3);
        orderService.addOrder(order13,customer3,company3);

// ---------------------------------------------------------------------------------------------------------------------- //

       // companyService.addCompany();




// ---------------------------------------------------------------------------------------------------------------------- //
        System.out.println("Sistemdeki tüm müşteriler");
        customerService.getAllCustomers();

        System.out.println("İçinde C harfi olan müşteriler");

        customerService.getFilteredCustomersByLetter("C");

//        System.out.println("Haziran ayında kayıt olan müşteriler");
//        System.out.println(customerService.getFilteredCustomersByMonth("Haziran"));

        System.out.println("Müşteriye ait faturalar");
        orderService.findOrdersByCustomer(customer.getId());

        System.out.println("Tüm faturalar");
        orderService.getAllOrders();
        System.out.println("1500 TL üzerindeki faturalar");
        orderService.getOrdersGreaterThanValue(1500.00);
        System.out.println("1500 TL üzerindeki faturaların ortalaması");
        orderService.getAverageOfOrderGreaterThanValue(1500.00);
        System.out.println("500 TL altındaki faturalara sahip müşterilerin isimleri");
        orderService.getCustomerNameWithOrderByLesserThanValue(500.00);

        System.out.println("Deneme : Tek müşterinin faturaları");

        orderService.getOrdersFromOneCustomer(customer);

        System.out.println("Haziran ayında kayıt olan müşterilerin faturalarının toplamı");

        orderService.getSumAmount("Haziran");

        System.out.println("Şirkete ait detaylar: ");
        companyService.getCompanyDetail(company2);

        System.out.println("Şirketin sektörü: ");
        System.out.println(CompanyService.getCompanySectorById(company1.getId()));


        System.out.println("Haziran ayını faturalarını ortalaması 750 altı olan firmalarının sektörleri: ");
        companyService.getSectorFromFilteredCompanies(750.00,"Haziran");

        System.out.println("************************");













    }
}
