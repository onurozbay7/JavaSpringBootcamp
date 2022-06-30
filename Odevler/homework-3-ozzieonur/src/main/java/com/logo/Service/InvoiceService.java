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
       return invoiceRepository.findById(id);
    }

    public Invoice updateInvoice(int id, Invoice invoiceRequest) {
        return invoiceRepository.update(id,invoiceRequest);
    }

    public Invoice deleteInvoice(int id) {
        return invoiceRepository.delete(id);
    }
}
