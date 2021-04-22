package cl.escalab.microservices.service;

import java.util.List;
import java.util.Optional;

import cl.escalab.microservices.model.UsuarioHasItem;

public interface UsuarioHasItemService {
	
	public Optional<UsuarioHasItem> findByIdUsuarioAndIdItem(Long idUsuario, Long idItem);
	public List<UsuarioHasItem> findAll();
	public UsuarioHasItem save(UsuarioHasItem usuarioHasItem);
	public void deleteById(Long id);
	public boolean usuarioHasItem(Long idUsuario, Long idItem);
	
}
