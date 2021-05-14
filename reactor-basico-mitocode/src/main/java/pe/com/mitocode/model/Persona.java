package pe.com.mitocode.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class Persona {
	
	@EqualsAndHashCode.Include
	private Integer id;
	
	@EqualsAndHashCode.Include
	private String nombre;
	
	@EqualsAndHashCode.Exclude
	private Integer edad;	
	
}
