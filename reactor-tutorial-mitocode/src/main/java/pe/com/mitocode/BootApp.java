package pe.com.mitocode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import pe.com.mitocode.model.Persona;
import pe.com.mitocode.operador.condicional.Condicional;
import pe.com.mitocode.operador.matematico.Matematico;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@SpringBootApplication
public class BootApp implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(BootApp.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
//		new Condicional().timeOut();
		new Matematico().summarizing();
	}

	
	
	
	
	
	
	
	
	public void mono() {
		Persona obj1 = Persona.builder().id(1).nombre("person_1").edad(1).build();
		Mono.just(obj1)
		.subscribe( obj -> {
			log.info("objeto MONO es = {}" , obj);
		});
	}
	
	
	public void flux() {
		
		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		Flux.fromIterable(lista)
		.subscribe(obj -> {
			
			log.info("objeto FLUX de la lista es = {}" , obj);
		});
		
	}
	
	public void fluxToMono() {
		List<Persona> lista = new ArrayList<>();
		lista.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		Flux<Persona> flux = Flux.fromIterable(lista);
		flux.collectList().subscribe( objList -> {
			log.info("mono.. = {}" , objList);
		});
	}
	
	
	//******************************************************************************** 
	
	public static void crearConReactor() {

		Persona obj1 = Persona.builder().id(1).nombre("cesar lopez").edad(1).build();

		Mono.just(obj1)
		.doOnNext(obj -> {
			log.info("Reactor doOnNext = {}", obj);
		})
		.subscribe( obj -> {
			log.info("Reactor subscribe = {}" , obj);
		});

	}

	public static void crearConRx() {

		Persona obj1 = Persona.builder().id(1).nombre("cesar lopez").edad(1).build();

		Observable.just(obj1)
		.doOnNext(obj -> {
			log.info("Rx doOnNext = {}", obj);
		})
		.subscribe(obj -> {
			log.info("Rx subscribe = {}" , obj);
		});
	}
	
	
}


