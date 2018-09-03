package com.agharibi.demo.web;

import com.agharibi.demo.domain.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Component
@ConfigurationProperties("demo")
public class StockQuoteClient {

    private String host;
    private String port;
    private String path;



    public Flux<Quote> getQutoeStream() {

        String url = "http://" + host + ":" + port;
        log.debug("URL set is: " + url);
        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .uri(path)
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(Quote.class);
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
