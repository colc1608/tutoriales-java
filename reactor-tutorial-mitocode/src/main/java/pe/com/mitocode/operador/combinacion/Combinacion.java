package pe.com.mitocode.operador.combinacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import pe.com.mitocode.model.Persona;
import pe.com.mitocode.model.Venta;
import reactor.core.publisher.Flux;

@Slf4j
public class Combinacion {
	
	
	public void merge() {
		
		List<Persona> lista1 = new ArrayList<>();
		lista1.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista1.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista1.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		List<Persona> lista2 = new ArrayList<>();
		lista2.add(Persona.builder().id(4).nombre("persona4").edad(50).build());
		lista2.add(Persona.builder().id(5).nombre("persona5").edad(60).build());
		lista2.add(Persona.builder().id(6).nombre("persona6").edad(70).build());
		
		List<Venta> lista3 = new ArrayList<>();
		lista3.add(Venta.builder().idVenta(70).fecha(new Date()).build());
		
		
		
		Flux<Persona> flux1 = Flux.fromIterable(lista1);
		Flux<Persona> flux2 = Flux.fromIterable(lista2);
		Flux<Venta> flux3 = Flux.fromIterable(lista3);
		
		
		
		//flux1 = flux1.merge(flux1, flux2);
		
		Flux
		.merge(flux1, flux2,flux3)
		.subscribe(result -> {
			log.info("result = {}", result);
		});
		
		
//		flux1.subscribe(result -> {
//			log.info("result = {}", result);
//		});
		
	}
	
	
	public void zip () {
		List<Persona> lista1 = new ArrayList<>();
		lista1.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista1.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista1.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		List<Persona> lista2 = new ArrayList<>();
		lista2.add(Persona.builder().id(4).nombre("persona4").edad(50).build());
		lista2.add(Persona.builder().id(5).nombre("persona5").edad(60).build());
		lista2.add(Persona.builder().id(6).nombre("persona6").edad(70).build());
		
		List<Venta> lista3 = new ArrayList<>();
		lista3.add(Venta.builder().idVenta(70).fecha(new Date()).build());
		
		Flux<Persona> flux1 = Flux.fromIterable(lista1);
		Flux<Persona> flux2 = Flux.fromIterable(lista2);
		Flux<Venta> flux3 = Flux.fromIterable(lista3);
		
		/*
		Flux
		.zip(flux1, flux2, (p1,p2) ->  String.format("Flux1: %s | Flux2: %s ", p1, p2) )
		.subscribe(result -> log.info("result = {}", result));
		
		
		Flux
		.zip(flux1, flux2 )
		.subscribe(result -> log.info("result = {}", result));
		
		*/
		Flux
		.zip(flux1, flux2, flux3 )
		.subscribe(result -> log.info("result = {}", result));
		
		
	}
	
	
	
	public void zipWith () {
		List<Persona> lista1 = new ArrayList<>();
		lista1.add(Persona.builder().id(1).nombre("persona1").edad(10).build());
		lista1.add(Persona.builder().id(2).nombre("persona2").edad(20).build());
		lista1.add(Persona.builder().id(3).nombre("persona3").edad(30).build());
		
		List<Persona> lista2 = new ArrayList<>();
		lista2.add(Persona.builder().id(4).nombre("persona4").edad(50).build());
		lista2.add(Persona.builder().id(5).nombre("persona5").edad(60).build());
		lista2.add(Persona.builder().id(6).nombre("persona6").edad(70).build());
		
		List<Venta> lista3 = new ArrayList<>();
		lista3.add(Venta.builder().idVenta(70).fecha(new Date()).build());
		
		Flux<Persona> flux1 = Flux.fromIterable(lista1);
		Flux<Persona> flux2 = Flux.fromIterable(lista2);
		Flux<Venta> flux3 = Flux.fromIterable(lista3);
		
		/*
		flux1
		.zipWith(flux2, (obj1, obj2) -> String.format("fx1: %s and fx2: %s", obj1, obj2) )
		.subscribe(result -> log.info("result = {}", result));
		*/
		
		flux1
		.zipWith(flux3, (obj1, venta) -> String.format("fx1: %s and fx2: %s", obj1, venta) )
		.subscribe(result -> log.info("result = {}", result));
		
	}
	
	
}
