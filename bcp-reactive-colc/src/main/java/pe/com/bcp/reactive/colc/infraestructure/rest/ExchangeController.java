package pe.com.bcp.reactive.colc.infraestructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.reactive.colc.business.port.UseCaseExchange;
import pe.com.bcp.reactive.colc.domain.Exchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
@RequestMapping("/api/exchange")
@Tag(name = "Controller Exchange", description = "Controller description exchange")
public class ExchangeController {
	
	private UseCaseExchange useCase;

    @Autowired
    public ExchangeController(UseCaseExchange useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    Flux<Exchange> getAll() {
        return useCase.findAll();
    }

    @PostMapping
    @Operation(description = "Create Exchange", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
    Mono<Exchange> save(@RequestBody Exchange request) {
    	log.info("request to save = {}", request);
    	return useCase.save(request);
    }

    @PutMapping
    Mono<Exchange> updateTodo(@RequestBody Exchange request) {
    	log.info("request to save = {}", request);
        return useCase.save(request);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteById(@PathVariable("id") Long id) {
        return useCase.deleteById(id);
    }
    
    @GetMapping("/{id}")
    @Operation(description = "Get by Id",
    	parameters = { @Parameter(name = "id", in = ParameterIn.PATH, required = true, description = "id parameter") })
    Mono<Exchange> findById(@PathVariable("id") Long id) {
        return useCase.findById(id);
    }
    
}
