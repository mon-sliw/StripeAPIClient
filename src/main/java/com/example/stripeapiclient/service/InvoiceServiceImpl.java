package com.example.stripeapiclient.service;

import com.example.stripeapiclient.client.InvoiceWebClient;
import com.example.stripeapiclient.model.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    InvoiceWebClient client;

    public InvoiceServiceImpl() {
        client = new InvoiceWebClient();
    }

    public InvoiceServiceImpl(InvoiceWebClient client) {
        this.client = client;
    }

    @Override
    public Invoice createInvoice(String customerId) {
        return client.createInvoice(customerId);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return client.getAllInvoices(null);
    }

    @Override
    public List<Invoice> getAllInvoicesByCustomer(String customerId) {
        return client.getAllInvoices(customerId);
    }

    @Override
    public Invoice getInvoiceById(String invoiceId) {
        return client.getInvoiceById(invoiceId);
    }
}
