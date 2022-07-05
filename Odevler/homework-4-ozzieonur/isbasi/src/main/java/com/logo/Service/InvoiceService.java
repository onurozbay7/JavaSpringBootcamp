package com.logo.Service;

import com.logo.Model.Invoice;
import com.logo.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;
    public Invoice createInvoice(Invoice invoiceRequest) {
        return invoiceRepository.save(invoiceRequest);

    }

    public List<Invoice> getAllInovice() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(int id) {
       return invoiceRepository.findById(id).orElseThrow();
    }

    public Invoice updateInvoice(int id, Invoice invoiceRequest) {

        Invoice foundInvoice = invoiceRepository.findById(id).orElseThrow();

        foundInvoice.setInvoiceNumber(invoiceRequest.getInvoiceNumber());
        foundInvoice.setComment(invoiceRequest.getComment());
        foundInvoice.setCustomerID(invoiceRequest.getCustomerID());
        foundInvoice.setInvocieType(invoiceRequest.getInvocieType());
        foundInvoice.setInvoiceDate(invoiceRequest.getInvoiceDate());


        return invoiceRepository.save(foundInvoice);
    }

    public String deleteInvoice(int id) {
        invoiceRepository.deleteById(id);

        return id + " id'li fatura silindi";
    }
}
