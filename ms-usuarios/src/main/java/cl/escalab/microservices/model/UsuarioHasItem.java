package cl.escalab.microservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario_has_item")
@IdClass(value = UsuarioHasItemPK.class)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(
  ignoreUnknown = true, 
  value = {
	"hibernateLazyInitializer",
	"handler",
	"usuario"})
public class UsuarioHasItem {
	
	@Id
	@Column(name = "id_usuario")
	private Long idUsuario;
	@Id
	@Column(name = "id_item")
	private Long idItem;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", insertable=false, updatable=false)
	private Usuario usuario;

}
