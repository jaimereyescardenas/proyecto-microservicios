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

import cl.escalab.microservices.exception.BadRequestException;
import cl.escalab.microservices.exception.ResourceNotFoundException;
import cl.escalab.microservices.model.Tipo;
import cl.escalab.microservices.service.TipoService;

@RestController
@RequestMapping("/api")
public class TipoController {

	@Autowired
	private TipoService tipoService;
	
	
	@GetMapping("/list")
	public List<Tipo> getTipos() {
		List<Tipo> tipos = tipoService.findAll();
		return tipos;
	}
	
	@GetMapping("/find/id/{id}")
	public Tipo getById(@PathVariable(name = "id") Long id) {
		
		if (id <= 0) {
			throw new BadRequestException();
		}
		
		Optional<Tipo> tipo = tipoService.findById(id);
		
		if (!tipo.isPresent()) {
			throw new ResourceNotFoundException();
		}
		
		return tipo.get();
		
	}
	
	@PostMapping("/save")
	public Tipo createTipo(@RequestBody Tipo tipo) {
		
		if (tipo == null) {
			throw new BadRequestException();
		}
		
		Tipo savedTipo = tipoService.save(tipo);
		return savedTipo;
	}
	
	@PutMapping("/edit/{id}")
	public Tipo edit(@PathVariable(name = "id") Long id, @RequestBody Tipo tipo) {
		
		if (id != tipo.getId()) {
			throw new BadRequestException();
		}
		
		Tipo modifiedTipo = tipoService.save(tipo);
		return modifiedTipo;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public Tipo delete(@PathVariable(name = "id") Long id) {
		
		Optional<Tipo> tipo = tipoService.findById(id);
		
		if (!tipo.isPresent()) {
			throw new ResourceNotFoundException();
		}
		
		tipoService.deleteById(id);
		return tipo.get();
		
	}
	
	@GetMapping("/random")
	public Tipo getRandom() {
		
		return tipoService.getRandom();
		
	}
	
}
