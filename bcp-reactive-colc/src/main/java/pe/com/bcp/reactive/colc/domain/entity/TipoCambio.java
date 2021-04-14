package pe.com.bcp.reactive.colc.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TipoCambio {
	private Double precioVenta;
	private Double precioCompra;
}
