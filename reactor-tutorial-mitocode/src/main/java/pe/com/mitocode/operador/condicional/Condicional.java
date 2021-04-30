package pe.com.mitocode.operador.condicional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import pe.com.mitocode.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class Condicional {

	public void defaultIfEmpty() {
		
//		Mono.empty()
		Flux.empty()
		.defaultIfEmpty(Persona.builder().id(1).nombre("DEFAULT").edad(10).build())
		.subscribe(result -> log.info("x = {} ", result));
		
	}
	
	public void takeUntil() {

		List<Persona> lista1 = new ArrayList<>();
		lista1.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista1.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista1.add(Persona.builder().id(3).nombre("persona3").edad(30).build());

		Flux<Persona> flux1 = Flux.fromIterable(lista1);
		
		flux1
		.takeUntil(obj -> obj.getEdad() > 5)
		.subscribe(result -> log.info("result = {} ", result));
	}
	
	public void timeOut() throws InterruptedException {

		List<Persona> lista1 = new ArrayList<>();
		lista1.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista1.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista1.add(Persona.builder().id(3).nombre("persona3").edad(30).build());

		Flux<Persona> flux1 = Flux.fromIterable(lista1);
		
		flux1
		.delayElements(Duration.ofSeconds(1))
		.timeout(Duration.ofSeconds(2))
		.subscribe(result -> log.info("result = {} ", result));
		
		Thread.sleep(10000);
	}
	
	
}
