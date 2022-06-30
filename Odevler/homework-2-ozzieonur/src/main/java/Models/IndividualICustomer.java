package Models;

import Services.IDiscount;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IndividualICustomer implements ICustomer {

    private final int id;
    private String fullName;
    private int age;

    private String dateOfReg;
    public List<Order> orderList = new ArrayList<>();

    public IndividualICustomer(String fullName, int age, String dateOfReg) {
        id = i.incrementAndGet();
        this.fullName = fullName;
        this.age = age;
        this.dateOfReg = dateOfReg;
    }

    public IndividualICustomer(String fullName, int age, String dateOfReg, List<Order> orderList) {
        id = i.incrementAndGet();
        this.fullName = fullName;
        this.age = age;
        this.dateOfReg = dateOfReg;
        this.orderList = orderList;
    }

    @Override
    public void showCustomerInfo() {
        System.out.println("Bireysel Müşteri");
        System.out.println("Müşteri ismi: " + fullName);
    }

    @Override
    public List<Order> getOrderList() {return orderList;}

    @Override
    public int getId() {return id;}

    @Override
    public String getFullName() {return fullName;}

    @Override
    public void setFullName(String fullName) {this.fullName = fullName;}

    @Override
    public int getAge() {return age;}

    @Override
    public void setAge(int age) {this.age = age;}

    @Override
    public void setOrderList(List<Order> orderList) {this.orderList = orderList;}

    @Override
    public String getDateOfReg() {return dateOfReg;}

    @Override
    public void setDateOfReg(String dateOfReg) {this.dateOfReg = dateOfReg;}
}
