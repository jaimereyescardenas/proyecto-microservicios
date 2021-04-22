package cl.escalab.microservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.escalab.microservices.model.UsuarioHasItem;

@Repository
public interface UsuarioHasItemRepository extends JpaRepository<UsuarioHasItem, Long>{
	public Optional<UsuarioHasItem> findByIdUsuarioAndIdItem(Long idUsuario, Long idItem);
}
