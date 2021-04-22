package cl.escalab.microservices.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UsuarioHasItemPK implements Serializable {

	private static final long serialVersionUID = 6340076106797381607L;
	
	private Long idUsuario;
	private Long idItem;
	
}
