package cl.escalab.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
	
	private Long id;
	private String nombre;
	private String descripcion;
	private String urlImagen;
	private Long idTipo; 

}
