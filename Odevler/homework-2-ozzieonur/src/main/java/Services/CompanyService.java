package Services;

import Models.Company;
import Models.Order;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompanyService {
    Company company;


    static List<Company> companyList = new ArrayList<>();
    static Map<Company, List<Order>> companyMap = new HashMap<>();

    public void addCompany(Company company){
        companyList.add(company);
        companyMap.put(company,company.companyOrderList);
      //  companyMap.put(company,list);
    }

    public void getCompanyDetail(Company company) {
        Map<Object, List<Integer>> result = company.getOneCompanyMap().entrySet().stream()
                .collect(Collectors.toMap(elem -> elem.getKey().getFullName() + " ", elem -> elem.getValue().stream()
                        .map(Order::getTotalAmount).collect(Collectors.toList())));

        result.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + new ArrayList<>(entry.getValue())));
    }

    public static String getCompanySectorById(int companyId){

        return companyList.stream().filter(company -> company.getId() == companyId).map(Company::getSector).collect(Collectors.joining());
    }



    public void getSectorFromFilteredCompanies(Double value, String month){
        for (Company company: companyList){
            OrderService.getAverageOfOrdersFromOneCompany(company,value,month);
        }
    }


}
