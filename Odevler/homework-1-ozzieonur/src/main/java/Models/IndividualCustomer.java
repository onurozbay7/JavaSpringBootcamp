package Models;

import Services.IDiscount;

import java.util.List;

public class IndividualCustomer extends Customer implements IDiscount {
    public IndividualCustomer(String fullName, int age, String dateOfReg, List<Order> orderList) {
        super(fullName, age, dateOfReg, orderList);
    }

    public IndividualCustomer(String fullName, int age, String dateOfReg) {
        super(fullName, age, dateOfReg);
    }


    @Override
    public void addDiscount() {

    }
}
