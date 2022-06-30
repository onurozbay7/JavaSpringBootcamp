package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface ICustomer {

   AtomicInteger i = new AtomicInteger(0);


    public List<Order> getOrderList(); //





     int getId();

     String getFullName();

     void setFullName(String fullName);

     int getAge();

     void setAge(int age);

     void setOrderList(List<Order> orderList);

     String getDateOfReg();//

     void setDateOfReg(String dateOfReg);

     void showCustomerInfo();


}
