package pe.com.bcp.reactive.colc.business.port.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.reactive.colc.business.port.UseCaseExchange;
import pe.com.bcp.reactive.colc.domain.Exchange;
import pe.com.bcp.reactive.colc.infraestructure.repository.RepoReactive;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class UseCaseExchangeImpl implements UseCaseExchange {
	
	private RepoReactive repository;
	
    @Autowired
    public UseCaseExchangeImpl(RepoReactive repository) {
        this.repository = repository;
    }

    
    
	@Override
	public Flux<Exchange> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<Exchange> save(Exchange request) {
		log.info("request to save = {}", request);
		return repository.save(request);
	}

	@Override
	public Mono<Exchange> update(Exchange request) {
		return repository.save(request);
	}

	@Override
	public Mono<Void> deleteById(Long id) {
		return repository.deleteById(id);
	}

	@Override
	public Mono<Exchange> findById(Long id) {
		return repository.findById(id);
	}
	
    

}
