package pe.com.mitocode.operador.error;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import pe.com.mitocode.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
public class ErrorOperacion {
	
	public void retry() {
		
		List<Persona> lista1 = new ArrayList<>();
		lista1.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista1.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista1.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		Flux<Persona> flux1 = Flux.fromIterable(lista1);
		
		flux1
		.concatWith( Flux.error(new RuntimeException("MI ERROR") ) )
		.retry(1)
		.doOnNext(obj -> {
			log.info("next = {}", obj);
		})
		.subscribe();
		
	}
	
	public void errorReturn() {
		List<Persona> lista1 = new ArrayList<>();
		lista1.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista1.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista1.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		Flux<Persona> flux1 = Flux.fromIterable(lista1);
		
		flux1
		.concatWith( Flux.error(new RuntimeException("MI ERROR") ) )
		.onErrorReturn(Persona.builder().id(-5).build())
		.subscribe(result -> log.info("result = {}", result) );
	}
	
	
	public void errorResumen() {
		List<Persona> lista1 = new ArrayList<>();
		lista1.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista1.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista1.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		Flux<Persona> flux1 = Flux.fromIterable(lista1);
		
		flux1
		.concatWith( Flux.error(new RuntimeException("MI ERROR") ) )
		.onErrorResume(e -> Mono.just( Persona.builder().id(-15).nombre(e.getMessage()).build() )  ) 
		.subscribe(result -> log.info("result = {}", result) );
		
	}
	
	
	public void errorMap() {
		List<Persona> lista1 = new ArrayList<>();
		lista1.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista1.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista1.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		Flux<Persona> flux1 = Flux.fromIterable(lista1);
		
		flux1
		.concatWith( Flux.error(new RuntimeException("MI ERROR Map") ) )
		.onErrorMap( ex -> new InterruptedException(ex.getMessage()) ) 
		.subscribe(result -> log.info("result = {}", result) );
		
	}
	
	
	
}
