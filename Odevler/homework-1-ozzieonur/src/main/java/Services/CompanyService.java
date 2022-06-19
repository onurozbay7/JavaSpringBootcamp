package Services;

import Models.Company;
import Models.Order;


import java.util.*;
import java.util.stream.Collectors;

public class CompanyService {

    static List<Company> companyList = new ArrayList<>(); // Tüm şirketleri tutan liste
    static Map<Company, List<Order>> companyMap = new HashMap<>();

    public void addCompany(Company company) { //  Şirket ekleyen fonksiyon
        companyList.add(company);
        companyMap.put(company, company.companyOrderList);
    }

    public void getCompanyDetail(Company company) { // Şirketin detaylarını listeleyen fonksiyon
        Map<Object, List<Integer>> result = company.getOneCompanyMap().entrySet().stream()
                .collect(Collectors.toMap(elem -> elem.getKey().getFullName(), elem -> elem.getValue().stream()
                        .map(Order::getTotalAmount).collect(Collectors.toList())));

        result.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + new ArrayList<>(entry.getValue())));
    }

    public void getSectorFromFilteredCompanies(Double value, String month) { // Filtrelenen şirketlerin sektörlerini getiren fonksiyon.
        for (Company company : companyList) {
            OrderService.getAverageOfOrdersFromOneCompany(company, value, month);
        }
    }


}
