package pe.com.mitocode.operador.filtrado;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import pe.com.mitocode.model.Persona;
import reactor.core.publisher.Flux;

@Slf4j
public class Filtrado {

	public void filter() {

		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());

		Flux<Persona> flux = Flux.fromIterable(lista);

		flux = flux.filter(f -> f.getEdad() >= 20);

		flux.subscribe(result -> {
			log.info("result = {}", result);
		});

	}

	public void distinct() {
		
		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(1).nombre("persona1").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		Flux<Persona> flux = Flux.fromIterable(lista);
		
		flux = flux.distinct( );
		
		flux.subscribe(result -> { log.info("result = {}" , result); });
		
		
		// *******************************************************************************
		
		// Primitivos
		/*
		List listaNumeros = List.of(1, 1, 3);
		Flux.fromIterable(listaNumeros)
		.distinct()
		.subscribe(result -> {
			log.info("result = {}", result);
		});
		*/

	}
	
	public void take() {
		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		Flux<Persona> flux = Flux.fromIterable(lista);
		flux = flux.take(5);
		flux.subscribe(result -> { log.info("result = {}" , result); });
	}
	
	
	public void takeLast() {
		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		Flux<Persona> flux = Flux.fromIterable(lista);
		flux = flux.takeLast(1);
		flux.subscribe(result -> { log.info("result = {}" , result); });
	}
	
	public void skip() {
		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		Flux<Persona> flux = Flux.fromIterable(lista);
		flux = flux.skip(2);
		flux.subscribe(result -> { log.info("result = {}" , result); });
	}
	
	public void skipLast() {
		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		Flux<Persona> flux = Flux.fromIterable(lista);
		flux = flux.skipLast(1);
		flux.subscribe(result -> { log.info("result = {}" , result); });
	}
	
}
