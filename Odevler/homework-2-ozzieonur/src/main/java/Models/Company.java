package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Company {
    private static final AtomicInteger i = new AtomicInteger(0);
    private final int id;
    private String name;
    private String sector;
    private String description;
    public Map<ICustomer, List<Order>> oneCompanyMap = new HashMap<>();
    public List<Order> companyOrderList = new ArrayList<>();




    public Company(int id, String name, String sector, String description) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.description = description;
    }

    public Company(String name, String sector, String description) {
        id = i.incrementAndGet();
        this.name = name;
        this.sector = sector;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<ICustomer, List<Order>> getOneCompanyMap() {
        return oneCompanyMap;
    }

    public void setOneCompanyMap(Map<ICustomer, List<Order>> oneCompanyMap) {
        this.oneCompanyMap = oneCompanyMap;
    }

    public List<Order> getCompanyOrderList() {
        return companyOrderList;
    }

    public void setCompanyOrderList(List<Order> companyOrderList) {
        this.companyOrderList = companyOrderList;
    }
}
