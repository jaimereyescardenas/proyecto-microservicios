package cl.escalab.microservices.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.escalab.microservices.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findByNombre(String nombre);
	Set<Usuario> findByItems_IdItem(Long idItem);
	
}
