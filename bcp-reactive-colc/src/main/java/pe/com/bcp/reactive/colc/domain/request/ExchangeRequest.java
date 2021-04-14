package pe.com.bcp.reactive.colc.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExchangeRequest {
    private Double montoEnviado;
    private String tipoOperacion;
    private String monedaOrigen;
    private String monedaDestino;
}
