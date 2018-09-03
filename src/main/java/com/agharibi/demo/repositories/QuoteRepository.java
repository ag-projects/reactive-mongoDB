package com.agharibi.demo.repositories;

import com.agharibi.demo.domain.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuoteRepository extends ReactiveMongoRepository<Quote, String>{
}
