package cl.escalab.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoDto {

	private Long id;
	private String nombre;
	private Double probabilidad;
	
}