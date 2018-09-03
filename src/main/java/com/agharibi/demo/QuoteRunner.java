package com.agharibi.demo;


import com.agharibi.demo.domain.Quote;
import com.agharibi.demo.web.StockQuoteClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;


// @Component
public class QuoteRunner implements CommandLineRunner {

    private final StockQuoteClient stockQuoteClient;

    public QuoteRunner(StockQuoteClient stockQuoteClient) {
        this.stockQuoteClient = stockQuoteClient;
    }

    @Override
    public void run(String... args) throws Exception {

        Flux<Quote> quoteFlux = stockQuoteClient.getQutoeStream();
        quoteFlux.subscribe(System.out::println);
    }
}
