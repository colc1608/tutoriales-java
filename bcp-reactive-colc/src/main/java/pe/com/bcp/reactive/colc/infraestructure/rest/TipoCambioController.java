package pe.com.bcp.reactive.colc.infraestructure.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.bcp.reactive.colc.business.port.UseCaseTipoCambio;
import pe.com.bcp.reactive.colc.domain.TipoCambio;



@RestController
@RequestMapping("/api/tipoCambio")
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
    
}
