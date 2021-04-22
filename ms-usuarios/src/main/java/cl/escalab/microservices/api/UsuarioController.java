package cl.escalab.microservices.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.escalab.microservices.dto.GetItemDto;
import cl.escalab.microservices.dto.ItemDto;
import cl.escalab.microservices.dto.ItemResponseDto;
import cl.escalab.microservices.exception.BadRequestException;
import cl.escalab.microservices.exception.ResourceNotFoundException;
import cl.escalab.microservices.model.Usuario;
import cl.escalab.microservices.service.ItemService;
import cl.escalab.microservices.service.UsuarioHasItemService;
import cl.escalab.microservices.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioHasItemService usuarioHasItemService;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/list")
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = usuarioService.findAll();
		return usuarios;
	}
	
	@GetMapping("/find/id/{id}")
	public Usuario getById(@PathVariable(name = "id") Long id) {
		
		if (id <= 0) {
			throw new BadRequestException();
		}
		
		Optional<Usuario> usuario = usuarioService.findById(id);
		
		if (!usuario.isPresent()) {
			throw new ResourceNotFoundException();
		}
		
		return usuario.get();
		
	}
	
	@PostMapping("/save")
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		
		if (usuario == null) {
			throw new BadRequestException();
		}
		
		Usuario savedUsuario = usuarioService.save(usuario);
		return savedUsuario;
	}
	
	@PutMapping("/edit/{id}")
	public Usuario edit(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario) {
		
		if (id != usuario.getId()) {
			throw new BadRequestException();
		}
		
		Usuario modifiedUsuario = usuarioService.save(usuario);
		return modifiedUsuario;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public Usuario delete(@PathVariable(name = "id") Long id) {
		
		Optional<Usuario> usuario = usuarioService.findById(id);
		
		if (!usuario.isPresent()) {
			throw new ResourceNotFoundException();
		}
		
		usuarioService.deleteById(id);
		return usuario.get();
		
	}
	
	@PostMapping("obtain")
	public ItemResponseDto getRandomItem(@RequestBody GetItemDto datos) {
		
		Long idUsuario = datos.getIdUsuario();
		
		if (idUsuario == null || idUsuario <= 0) {
			throw new BadRequestException();
		}
		
		ItemResponseDto itemResponse = new ItemResponseDto();
		
		ItemDto item = itemService.getRandomItem();
		Long idItem = item.getId();
		
		if (usuarioHasItemService.usuarioHasItem(idUsuario, idItem)) {
			itemResponse.setRepetido(true);
		} else {
			itemResponse.setRepetido(false);
		}
		
		itemResponse.setItem(item);
		return itemResponse;
		
	}
	
}
