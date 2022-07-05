package com.logo.Repository;

import com.logo.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface InvoiceRepository  extends JpaRepository<Invoice, Integer> {


}
