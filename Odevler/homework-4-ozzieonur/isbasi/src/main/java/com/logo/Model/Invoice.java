package com.logo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.logo.Model.enums.InvocieType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private int customerID;

    private InvocieType invocieType;

    private String invoiceNumber;

    private LocalDate invoiceDate;

    private String comment;

    @JsonManagedReference
    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceProducts> invoiceProducts;


}