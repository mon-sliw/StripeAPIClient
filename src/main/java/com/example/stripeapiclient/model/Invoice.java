package com.example.stripeapiclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    private String id;

    private Boolean autoadvance;

    private String charge;

    private String collection_method;

    private String currency;

    private String customer;

    private String description;

    private String hosted_invoice_url;

    private LineItem[] lines;

    private Map<String, String> metadata = new HashMap<>();

    private String payment_intent;

    private Date period_end;

    private Date period_start;

    private String status;

    private String subscription;

    private Integer total;
}
