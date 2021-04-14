package pe.com.bcp.reactive.colc.infraestructure.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.reactive.colc.business.port.UseCaseTipoCambio;
import pe.com.bcp.reactive.colc.domain.entity.TipoCambio;


@Slf4j
@RestController
@RequestMapping("/api/tipoCambio")
@Tag(name = "Controller TipoCambio", description = "Controller description TipoCambio")
public class TipoCambioController {
	
	private UseCaseTipoCambio useCase;

    @Autowired
    public TipoCambioController(UseCaseTipoCambio useCase) {
        this.useCase = useCase;
    }
    
    
    @GetMapping
    List<TipoCambio> getAll() {
        return useCase.findAll();
    }
    
    @PutMapping
    TipoCambio update(@RequestBody TipoCambio request) {
    	return useCase.update(request);
    }
    
}
