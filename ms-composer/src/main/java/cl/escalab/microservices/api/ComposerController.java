package cl.escalab.microservices.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.escalab.microservices.composer.ResponseComposer;
import cl.escalab.microservices.dto.UsuarioComposeDto;

@RestController
@RequestMapping("/api")
public class ComposerController {
	
	@Autowired
	private ResponseComposer responseComposer;

	@GetMapping("/userdetails/{id}")
	public UsuarioComposeDto getUsuarioItems(@PathVariable(name = "id")  Long id) {
		return responseComposer.getUsuarioItems(id);
	}
	
}
