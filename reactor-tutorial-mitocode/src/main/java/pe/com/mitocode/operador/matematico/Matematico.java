package pe.com.mitocode.operador.matematico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import pe.com.mitocode.model.Persona;
import reactor.core.publisher.Flux;

@Slf4j
public class Matematico {
	
	public void average() {

		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());

		Flux<Persona> flux = Flux.fromIterable(lista);
		
		flux
		.collect(Collectors.averagingInt(Persona::getEdad))
		.subscribe(result -> log.info("result = {}", result));
	}
	
	
	public void count() {

		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());

		Flux<Persona> flux = Flux.fromIterable(lista);
		
		flux
		.count()
		.subscribe(result -> log.info("result = {}", result));
	}
	
	public void minOrMax() {

		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());

		Flux<Persona> flux = Flux.fromIterable(lista);
		
		flux
		.collect(Collectors.minBy(Comparator.comparing(Persona::getEdad)))
//		.collect(Collectors.maxBy(Comparator.comparing(Persona::getEdad)))
		.subscribe(result -> log.info("result = {}", result.get()));
	}
	
	
	public void sum() {

		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());

		Flux<Persona> flux = Flux.fromIterable(lista);
		
		flux
		.collect(Collectors.summingInt( Persona::getEdad) )
		.subscribe(result -> log.info("result = {}", result) );
	}
	
	
	
	public void summarizing() {

		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());

		Flux<Persona> flux = Flux.fromIterable(lista);
		
		flux
		.collect(Collectors.summarizingInt(Persona::getEdad) )
		.subscribe(result -> log.info("result = {}", result) );
	}
	
	
	
}
