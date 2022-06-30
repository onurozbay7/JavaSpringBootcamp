package Models;

public class CustomerFactory {

    public static ICustomer createCustomer(String customerType,String fullName, int age, String dateOfReg){
        ICustomer iCustomer;

        if(customerType.equals("Individual")) {
            iCustomer = new IndividualICustomer(fullName, age, dateOfReg);
        }
        else if(customerType.equals("Corparate")) {
            iCustomer = new CorporateICustomer(fullName, age, dateOfReg);
        }

        else {
            throw new RuntimeException(customerType+" adlı bir müşteri tipi mevcut değil.");
        }

        return iCustomer;
    }

}
