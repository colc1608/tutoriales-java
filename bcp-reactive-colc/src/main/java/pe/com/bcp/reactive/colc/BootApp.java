package pe.com.bcp.reactive.colc;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.DatabaseClient;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import pe.com.bcp.reactive.colc.domain.Exchange;
import pe.com.bcp.reactive.colc.infraestructure.repository.RepoReactive;
import reactor.core.publisher.Flux;
import java.util.stream.Stream;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "BCP - Exchange", version = "1.0", description = "BCP - Documentation APIs Exchange v1.0.0"))
public class BootApp {

	public static void main(String[] args) {
		SpringApplication.run(BootApp.class, args);
	}

	@Bean
	ApplicationRunner init(RepoReactive repository, DatabaseClient client) {

		String scriptTableCreate = "create table IF NOT EXISTS Exchange ( id SERIAL PRIMARY KEY, MONTO_ENVIADO DECIMAL(10,3) , MONTO_RECIBIDO decimal(10,3) , MONEDA_ORIGEN varchar (50) , MONEDA_DESTINO varchar (50) , TIPO_CAMBIO decimal(10,3) , TIPO_OPERACION varchar (255)  );  ";
		String scriptTableDelete = "DELETE FROM Exchange;";

		Stream<Exchange> stream = Stream.of(
				Exchange.builder().monedaOrigen("soles").monedaDestino("dolares").montoEnviado(100.0)
						.montoRecibido(33.3).tipoOperacion("venta").build(),
				Exchange.builder().monedaOrigen("soles").monedaDestino("dolares").montoEnviado(200.0)
						.montoRecibido(66.3).tipoOperacion("venta").build(),
				Exchange.builder().monedaOrigen("soles").monedaDestino("dolares").montoEnviado(300.0)
						.montoRecibido(99.3).tipoOperacion("venta").build()
//				new Exchange(null, "prueba1", false),
//				new Exchange(null, "prueba2", true),
//				new Exchange(null, "prueba3", false)
		);

		return args -> {
			client.execute(scriptTableCreate).fetch().first().subscribe();
			client.execute(scriptTableDelete).fetch().first().subscribe();
			repository.saveAll(Flux.fromStream(stream)).then().subscribe();
		};
	}

}
