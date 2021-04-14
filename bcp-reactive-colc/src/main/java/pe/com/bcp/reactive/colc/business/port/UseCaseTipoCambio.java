package pe.com.bcp.reactive.colc.business.port;

import java.util.List;
import pe.com.bcp.reactive.colc.domain.TipoCambio;


public interface UseCaseTipoCambio {
	
	List<TipoCambio> findAll();
}
