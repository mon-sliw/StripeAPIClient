package com.example.stripeapiclient.client;

import com.example.stripeapiclient.model.Invoice;
import com.example.stripeapiclient.wrapper.GetInvoicesResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class InvoiceWebClient {

    WebClient client;
    private static final String URL = "https://api.stripe.com/v1/invoices";
    private static final String API_KEY = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";

    public InvoiceWebClient() {

        client = WebClient.builder()
                .baseUrl(URL)
                .defaultHeader("api_key", API_KEY)
                .build();

        log.info("new WebClient with baseUrl: {} and api_key: {}", URL, API_KEY);
    }

    public Invoice createInvoice(String customerId) {

        String bodyString = "\"customer\": \"" + customerId + "\"";

        log.info("createInvoice: POST request at: {} with body {{}}", URL, bodyString);

        Mono<Invoice> response = client.post()
                .bodyValue(bodyString)
                .retrieve()
                .bodyToMono(Invoice.class);

        return response.block();
    }

    public List<Invoice> getAllInvoices(String customerId) {

        String uri = "";
        if (customerId != null)
            uri = "?customer=" + customerId;

        log.info("getAllInvoices: GET request at: {}{}", URL, uri);

        Mono<GetInvoicesResponse> response = client.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(GetInvoicesResponse.class);

        List<Invoice> invoices = new ArrayList<>();
        response.blockOptional().map(r -> invoices.addAll(r.getData()));
        return invoices;
    }

    public Invoice getInvoiceById(String invoiceId) {

        String uri = "/" + invoiceId;

        log.info("getInvoice: GET request at: {}{}", URL, uri);

        Mono<Invoice> response = client.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Invoice.class);

        return response.block();
    }
}
