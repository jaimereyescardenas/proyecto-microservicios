package cl.escalab.microservices.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.escalab.microservices.dto.UsuarioDto;
import cl.escalab.microservices.model.Usuario;
import cl.escalab.microservices.model.UsuarioHasItem;
import cl.escalab.microservices.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepo.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return usuarioRepo.findById(id);
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepo.findByEmail(email);
	}

	@Override
	public Optional<Usuario> findByNombre(String nombre) {
		return usuarioRepo.findByNombre(nombre);
	}

	@Override
	public Set<Usuario> findByItems_IdItem(Long idItem) {
		return usuarioRepo.findByItems_IdItem(idItem);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
		usuarioRepo.deleteById(id);
	}

	@Override
	public UsuarioDto convertToDto(Usuario usuario) {
		
		UsuarioDto usuarioDto = new UsuarioDto();
		
		usuarioDto.setId(usuario.getId());
		usuarioDto.setNombre(usuario.getNombre());
		usuarioDto.setEmail(usuario.getEmail());
		
		List<Long> itemIds = usuario.getItems().stream()
				.map(UsuarioHasItem::getIdItem)
				.collect(Collectors.toList());
		
		usuarioDto.setItems(itemIds);
		
		return usuarioDto;
	}

}
