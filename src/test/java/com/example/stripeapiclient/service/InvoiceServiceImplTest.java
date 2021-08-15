package com.example.stripeapiclient.service;

import com.example.stripeapiclient.client.InvoiceWebClient;
import com.example.stripeapiclient.model.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceImplTest {

    private InvoiceService service;

    @Mock
    private InvoiceWebClient client;

    private static final String CUSTOMER_ID = "cus_AJ6mqoWgCYI0wY";
    private static final String INVOICE_ID = "in_1JOk512eZvKYlo2CNjqURmDo";

    @BeforeEach
    void setUp() {
        service = new InvoiceServiceImpl(client);
    }

    @Test
    void createInvoice() {

        when(client.createInvoice(CUSTOMER_ID))
                .thenReturn(Invoice.builder().customer(CUSTOMER_ID).build());

        Invoice createdInvoice = service.createInvoice(CUSTOMER_ID);

        assertNotNull(createdInvoice);
        assertEquals(CUSTOMER_ID, createdInvoice.getCustomer());
    }

    @Test
    void getAllInvoices() {

        when(client.getAllInvoices(null))
                .thenReturn(Arrays.asList(new Invoice(), new Invoice()));

        List<Invoice> invoices = service.getAllInvoices();

        assertNotNull(invoices);
        assertFalse(invoices.isEmpty());
    }

    @Test
    void getAllInvoicesByCustomer() {

        when(client.getAllInvoices(CUSTOMER_ID))
                .thenReturn(Arrays.asList(Invoice.builder().customer(CUSTOMER_ID).build(), Invoice.builder().customer(CUSTOMER_ID).build()));

        List<Invoice> invoices = service.getAllInvoicesByCustomer(CUSTOMER_ID);

        assertNotNull(invoices);
        assertFalse(invoices.isEmpty());
        invoices.forEach(i -> assertEquals(CUSTOMER_ID, i.getCustomer()));
    }

    @Test
    void getInvoiceById() {

        when(client.getInvoiceById(INVOICE_ID)).thenReturn(Invoice.builder().id(INVOICE_ID).build());

        Invoice invoice = service.getInvoiceById(INVOICE_ID);

        assertNotNull(invoice);
        assertEquals(INVOICE_ID, invoice.getId());
    }
}