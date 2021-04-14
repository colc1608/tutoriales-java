package pe.com.bcp.reactive.colc.domain.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table
public class Exchange {
	
	@Id
    private Long id;
	
	//@Column(value = "MONTO_ENVIADO")
    private Double montoEnviado;

	//@Column(value = "MONTO_RECIBIDO")
    private Double montoRecibido;

	//@Column(value = "MONEDA_ORIGEN")
    private String monedaOrigen;

	//@Column(value = "MONEDA_DESTINO")
    private String monedaDestino;

	//@Column(value = "TIPO_CAMBIO")
    private Double tipoCambio;

	//@Column(value = "TIPO_OPERACION")
    private String tipoOperacion;
    
}
