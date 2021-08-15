package com.example.stripeapiclient.wrapper;

import com.example.stripeapiclient.model.Invoice;
import lombok.Data;

import java.util.List;

@Data
public class GetInvoicesResponse {

    private String object;

    private String url;

    private Boolean has_more;

    private List<Invoice> data;
}
