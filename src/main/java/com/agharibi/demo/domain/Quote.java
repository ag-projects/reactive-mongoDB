package com.agharibi.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;


@Data
@Document
public class Quote {

    @Id
    private String id;
    private String tricker;
    private BigDecimal price;
    private Instant instant;
}