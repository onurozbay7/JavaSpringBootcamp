package com.logo.Controller;

import com.logo.Model.Invoice;
import com.logo.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoiceRequest){
        return invoiceService.createInvoice(invoiceRequest);
    }

    @GetMapping
    public List<Invoice> getAllInvoice(){
        return invoiceService.getAllInovice();
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id){
        return invoiceService.getInvoiceById(id);
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable int id, @RequestBody Invoice invoiceRequest){
        return invoiceService.updateInvoice(id,invoiceRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteInvoice(@PathVariable int id){
        return invoiceService.deleteInvoice(id);
    }
}
