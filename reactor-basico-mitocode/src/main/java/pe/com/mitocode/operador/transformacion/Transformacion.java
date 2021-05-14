package pe.com.mitocode.operador.transformacion;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import pe.com.mitocode.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class Transformacion {

	public void map() {
		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());

		Flux<Persona> flux = Flux.fromIterable(lista);

		flux = flux.map(obj -> {
			obj.setEdad(obj.getEdad() + 5);
			return obj;
		});

		flux.subscribe(obj -> {
			log.info("map = {}", obj);
		});
		
	}

	public void flatMap() {
		
		//NOTA = siempre debe devolver un MONO
		
		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());

		Flux<Persona> flux = Flux.fromIterable(lista);
		flux.flatMap(obj -> {
			obj.setEdad(obj.getEdad()  + 5 );
			return Mono.just(obj);
		});
	}
	
	
	public void groupBy() {
		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(1).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());

		Flux<Persona> flux = Flux.fromIterable(lista);
		
		flux
		.groupBy(Persona::getId)
		.flatMap(map -> map.collectList() )
		.subscribe(result -> {
			log.info("result = {}", result);
		});
		
	}
	
}
