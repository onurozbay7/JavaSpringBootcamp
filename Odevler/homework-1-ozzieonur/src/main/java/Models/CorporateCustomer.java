package Models;

import Services.IDiscount;

import java.util.List;

public class CorporateCustomer extends Customer implements IDiscount {

    public CorporateCustomer(String fullName, int age, String dateOfReg, List<Order> orderList) {
        super(fullName, age, dateOfReg, orderList);
    }

    public CorporateCustomer(String fullName, int age, String dateOfReg) {
        super(fullName, age, dateOfReg);
    }

    @Override
    public void addDiscount() {

    }
}
