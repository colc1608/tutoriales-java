package pe.com.mitocode.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Venta {
	private Integer idVenta;
	private Date fecha;
}
