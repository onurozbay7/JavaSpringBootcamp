package Models;

import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger i = new AtomicInteger(0);
    private final int id;
    private int customerId;
    private int companyId;
    private String description;
    private String month;
    private int totalAmount;

    public Order(int customerId, int companyId, String description, String month, int totalAmount) {
        id = i.incrementAndGet();
        this.customerId = customerId;
        this.companyId = companyId;
        this.description = description;
        this.month = month;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
