package pe.com.bcp.reactive.colc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TipoCambio {
	private String origen;
	private String destino;
	private Double precioVenta;
	private Double precioCompra;
	private String fecha;
}
