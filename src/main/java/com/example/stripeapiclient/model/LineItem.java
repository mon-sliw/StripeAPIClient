package com.example.stripeapiclient.model;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class LineItem {

    private String id;

    private Integer amount;

    private String currency;

    private String description;

    private Map<String, String> metadata = new HashMap<>();

    private Period period;

    private Price price;

    private Boolean proration;

    private Integer quantity;

    private String type;


    @Data
    private class Period {

        private Date end;

        private Date start;

    }

    @Data
    private class Price {

        private String id;

        private String object;

        private Boolean active;

        private String billing_scheme;

        private Date created;

        private String currency;

        private Boolean livemode;

        private String lookup_key;

        private Map<String, String> metadata = new HashMap<>();

        private String nickname;

        private String product;

        private Recurring recurring;

        private String tax_behavior;

        private Tiers tiers;

        private String tiers_mode;

        private TransformQuantity transform_quantity;

        private String type;

        private Integer unit_amount;

        private String unit_amount_decimal;

        @Data
        private class Recurring {

            private String aggregate_usage;

            private String interval;

            private Integer interval_count;

            private String usage_type;
        }

        @Data
        private class Tiers {

            private Integer flat_amount;

            private String flat_amount_decimal;

            private Integer unit_amount;

            private String unit_amount_decimal;

            private Integer up_to;
        }

        @Data
        private class TransformQuantity {

            private Integer divide_by;

            private String round;
        }
    }
}
