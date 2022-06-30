package com.logo.Model;

import com.logo.Model.enums.InvocieType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
public class Invoice {

    static AtomicInteger i = new AtomicInteger(0);

    private int id;

    private int customerID;

    private InvocieType invocieType;

    private String invoiceNumber;

    private LocalDate invoiceDate;

    private String comment;

    private List<Product> productList;

    public Invoice(int customerID, InvocieType invocieType, String invoiceNumber, LocalDate invoiceDate, String comment, List<Product> productList) {
        id = i.incrementAndGet();
        this.customerID = customerID;
        this.invocieType = invocieType;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.comment = comment;
        this.productList = productList;
    }
}