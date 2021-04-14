package pe.com.bcp.reactive.colc.business.port.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.reactive.colc.business.port.UseCaseTipoCambio;
import pe.com.bcp.reactive.colc.domain.entity.TipoCambio;

@Slf4j
@Service
public class UseCaseTipoCambioImpl implements UseCaseTipoCambio {
	
	@Autowired
	@Qualifier("tipoCambio")
	private TipoCambio tipoCambio;
	
	@Override
	public List<TipoCambio> findAll() {
		List<TipoCambio> list = new ArrayList<>();
		list.add(tipoCambio);
		return list;
	}

	@Override
	public TipoCambio update(TipoCambio request) {
		log.info("request = {}" , request.toString());
		log.info("TC in memory = {}" , this.tipoCambio.toString());
		
		this.tipoCambio.setPrecioCompra(request.getPrecioCompra());
		this.tipoCambio.setPrecioVenta(request.getPrecioVenta());
		
		log.info("TC in memory (update) = {}" , this.tipoCambio.toString());
		return this.tipoCambio;
	}
	
	
	
}
