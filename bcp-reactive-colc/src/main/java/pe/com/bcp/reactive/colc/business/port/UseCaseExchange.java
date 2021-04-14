package pe.com.bcp.reactive.colc.business.port;

import pe.com.bcp.reactive.colc.domain.Exchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UseCaseExchange {
	
	Flux<Exchange> findAll();
	Mono<Exchange> save(Exchange todo);
	Mono<Exchange> update(Exchange todo);
	Mono<Void> deleteById(Long id);
	Mono<Exchange> findById(Long id);
	
}
