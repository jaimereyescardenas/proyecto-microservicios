package cl.escalab.microservices.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(
  ignoreUnknown = true, 
  value = {
	"hibernateLazyInitializer",
	"handler"})
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "nombre", nullable = false, unique = true, length = 50)
	private String nombre;
	@Column(name = "email", nullable = false, unique = true, length = 100)
	private String email;
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	@OneToMany(
	  mappedBy = "usuario",
	  fetch = FetchType.EAGER,
	  cascade = CascadeType.ALL)
	private Set<UsuarioHasItem> items;

}
