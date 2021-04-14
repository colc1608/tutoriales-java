package pe.com.bcp.reactive.colc.infraestructure.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.com.bcp.reactive.colc.domain.entity.Exchange;

public interface RepoReactive extends ReactiveCrudRepository<Exchange, Long>{

}
