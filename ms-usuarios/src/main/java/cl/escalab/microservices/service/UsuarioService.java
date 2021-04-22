package cl.escalab.microservices.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cl.escalab.microservices.model.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	public Optional<Usuario> findById(Long id);
	public Optional<Usuario> findByEmail(String email);
	public Optional<Usuario> findByNombre(String nombre);
	public Set<Usuario> findByItems_IdItem(Long idItem);
	public Usuario save(Usuario usuario);
	public void deleteById(Long id);

}
