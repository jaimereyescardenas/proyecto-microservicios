package cl.escalab.microservices.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioComposeDto {

	private Long id;
	private String nombre;
	private String email;
	private List<ItemComposeDto> items;
	
}
