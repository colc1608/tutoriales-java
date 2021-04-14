package pe.com.bcp.reactive.colc.business.port.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pe.com.bcp.reactive.colc.business.port.UseCaseTipoCambio;
import pe.com.bcp.reactive.colc.domain.TipoCambio;

@Service
public class UseCaseTipoCambioImpl implements UseCaseTipoCambio {

	@Override
	public List<TipoCambio> findAll() {
		
		List<TipoCambio> list = new ArrayList<>();
		list.add(
				TipoCambio.builder()
				.origen("soles")
				.destino("dolares")
				.precioCompra(3.6123)
				.precioVenta(3.6456)
				.fecha("2021-04-14")
				.build()
				);
		
		list.add(
				TipoCambio.builder()
				.origen("euros")
				.destino("dolares")
				.precioCompra(2.6123)
				.precioVenta(2.6456)
				.fecha("2021-04-15")
				.build()
				);
		
		return list;
	}
	
}
