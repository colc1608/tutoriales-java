package pe.com.mitocode.operador.creacion;


import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import pe.com.mitocode.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
public class Creacion {
	
	
	public void empty() {
		Mono.empty();
		Flux.empty();
	}
	
	public void range() {
		Flux.range(0, 3)
		.doOnNext(i -> {
			log.info("valor de i = {}", i);
		})
		.subscribe();
	}

	public void repeat() {
		
		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		log.info("start FLUX");
		
		Flux.fromIterable(lista)
		.repeat(1)
		.subscribe( obj -> {
			log.info("FX - valor de obj = {}", obj);
		});
		
		log.info("start MONO");
		
		Mono.just(Persona.builder().id(1).nombre("persona1").edad(10).build())
		.repeat(2)
		.subscribe( obj -> {
			log.info("MONO - valor de obj = {}", obj);
		});
		
	}
}


