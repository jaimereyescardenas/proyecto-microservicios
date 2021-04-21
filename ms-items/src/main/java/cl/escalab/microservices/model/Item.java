package cl.escalab.microservices.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "item")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	
	@Transient
    public static final String SEQUENCE_NAME = "item_sequence";
	
	@Id
	private Long id;
	private String nombre;
	private String descripcion;
	private String urlImagen;
	private Long idTipo; 

}
