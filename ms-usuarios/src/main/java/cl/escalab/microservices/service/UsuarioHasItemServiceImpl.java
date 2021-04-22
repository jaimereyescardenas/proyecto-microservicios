package cl.escalab.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.escalab.microservices.model.UsuarioHasItem;
import cl.escalab.microservices.repository.UsuarioHasItemRepository;

@Service
public class UsuarioHasItemServiceImpl implements UsuarioHasItemService {

	@Autowired
	private UsuarioHasItemRepository usuarioHasItemRepo;
	
	@Override
	public Optional<UsuarioHasItem> findByIdUsuarioAndIdItem(Long idUsuario, Long idItem) {
		return usuarioHasItemRepo.findByIdUsuarioAndIdItem(idUsuario, idItem);
	}

	@Override
	public List<UsuarioHasItem> findAll() {
		return usuarioHasItemRepo.findAll();
	}

	@Override
	public UsuarioHasItem save(UsuarioHasItem usuarioHasItem) {
		return usuarioHasItemRepo.save(usuarioHasItem);
	}

	@Override
	public void deleteById(Long id) {
		usuarioHasItemRepo.deleteById(id);
	}

	@Override
	public boolean usuarioHasItem(Long idUsuario, Long idItem) {
		Optional<UsuarioHasItem> usuarioHasItem = usuarioHasItemRepo.findByIdUsuarioAndIdItem(idUsuario, idItem);
		return usuarioHasItem.isPresent();
	}

}
