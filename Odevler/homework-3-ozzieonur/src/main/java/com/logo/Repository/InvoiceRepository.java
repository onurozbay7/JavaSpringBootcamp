package com.logo.Repository;

import com.logo.Model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {

    static List<Invoice> invoiceList = new ArrayList<>(10);

    public Invoice save(Invoice invoiceRequest) {
        invoiceList.add(invoiceRequest);

        return invoiceRequest;
    }

    public List<Invoice> findAll() {
        return invoiceList;
    }

    public Invoice findById(int id) {
        return invoiceList.stream()
                .filter(invoice -> invoice.getId() == id)
                .findFirst().orElseThrow();
    }

    public Invoice update(int id, Invoice invoiceRequest) { // 2. yol = Nesnenin propertylerini set ederek update atma.
                                                            // 1.yol için Customer Repository -> update metoduna bakabilirsiniz.
        Invoice invoice = invoiceList.stream()
                .filter(invoice1 -> invoice1.getId() == id)
                .findFirst().orElseThrow();


        invoice.setInvoiceNumber(invoiceRequest.getInvoiceNumber());
        invoice.setComment(invoiceRequest.getComment());
        invoice.setCustomerID(invoiceRequest.getCustomerID());
        invoice.setInvocieType(invoiceRequest.getInvocieType());
        invoice.setInvoiceDate(invoiceRequest.getInvoiceDate());
        invoice.setProductList(invoiceRequest.getProductList());

        return invoice;

    }

    public Invoice delete(int id) {
        Invoice invoice = invoiceList.stream()
                .filter(invoice1 -> invoice1.getId() == id)
                .findFirst().orElseThrow();

        invoiceList.remove(invoice);

        return invoice;
    }
}
