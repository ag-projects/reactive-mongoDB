package com.agharibi.demo.service;

import com.agharibi.demo.domain.Quote;
import com.agharibi.demo.repositories.QuoteRepository;
import com.agharibi.demo.web.StockQuoteClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class QuoteMonitorService implements ApplicationListener<ContextRefreshedEvent>{

    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository quoteRepository;

    public QuoteMonitorService(StockQuoteClient stockQuoteClient, QuoteRepository quoteRepository) {
        this.stockQuoteClient = stockQuoteClient;
        this.quoteRepository = quoteRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        stockQuoteClient.getQutoeStream()
        .log("quote-monitor-service")
        .subscribe(quote -> {
            Mono<Quote> savedQuote = quoteRepository.save(quote);
            System.out.println("Quote ID: " + quote.getId());
        });
    }
}
