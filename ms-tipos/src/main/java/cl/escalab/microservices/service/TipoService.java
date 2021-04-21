package cl.escalab.microservices.service;

import java.util.List;
import java.util.Optional;

import cl.escalab.microservices.model.Tipo;

public interface TipoService {
	
	public Optional<Tipo> findById(Long id);
	public List<Tipo> findAll();
	public Tipo save(Tipo tipo);
	public void deleteById(Long id);
	
}
