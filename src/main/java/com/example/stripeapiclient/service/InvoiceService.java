package com.example.stripeapiclient.service;

import com.example.stripeapiclient.model.Invoice;

import java.util.List;

public interface InvoiceService {

    Invoice createInvoice(String customerId);

    List<Invoice> getAllInvoices();

    List<Invoice> getAllInvoicesByCustomer(String customerId);

    Invoice getInvoiceById(String invoiceId);
}
