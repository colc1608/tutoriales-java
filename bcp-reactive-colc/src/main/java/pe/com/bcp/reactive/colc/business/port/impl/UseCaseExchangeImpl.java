package pe.com.bcp.reactive.colc.business.port.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.reactive.colc.business.port.UseCaseExchange;
import pe.com.bcp.reactive.colc.domain.entity.Exchange;
import pe.com.bcp.reactive.colc.domain.entity.TipoCambio;
import pe.com.bcp.reactive.colc.domain.request.ExchangeRequest;
import pe.com.bcp.reactive.colc.infraestructure.repository.RepoReactive;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class UseCaseExchangeImpl implements UseCaseExchange {
	
	private RepoReactive repository;
	
	@Autowired
	@Qualifier("tipoCambio")
	private TipoCambio tipoCambio;
	
    @Autowired
    public UseCaseExchangeImpl(RepoReactive repository) {
        this.repository = repository;
    }
    
    
    
	@Override
	public Flux<Exchange> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<Exchange> save(ExchangeRequest request) {
		
		log.info("request to save = {}", request);
		
		Exchange entity = Exchange.builder()
		.montoEnviado(request.getMontoEnviado())
		.monedaOrigen(request.getMonedaOrigen())
		.monedaDestino(request.getMonedaDestino())
		.montoRecibido(calcularCambio(request))
		.tipoCambio(obtenerTipoCambio(request))
		.tipoOperacion(request.getTipoOperacion())
		.build();
		
		return repository.save(entity);
	}
	
	public Double calcularCambio(ExchangeRequest request) {
		if("VENTA".equalsIgnoreCase(request.getTipoOperacion()) ) {
			return request.getMontoEnviado() / tipoCambio.getPrecioVenta() ;
		}else {
			return request.getMontoEnviado() * tipoCambio.getPrecioCompra() ;
		}
	}
	
	public Double obtenerTipoCambio(ExchangeRequest request) {
		if("VENTA".equalsIgnoreCase(request.getTipoOperacion()) ) {
			return tipoCambio.getPrecioVenta() ;
		}else {
			return tipoCambio.getPrecioCompra() ;
		}
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
