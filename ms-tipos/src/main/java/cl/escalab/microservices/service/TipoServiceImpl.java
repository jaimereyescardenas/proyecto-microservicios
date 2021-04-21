package cl.escalab.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.escalab.microservices.model.Tipo;
import cl.escalab.microservices.repository.TipoRepository;

@Service
public class TipoServiceImpl implements TipoService {
	
	@Autowired
	private TipoRepository tipoRepo;

	@Override
	public Optional<Tipo> findById(Long id) {
		return tipoRepo.findById(id);
	}

	@Override
	public List<Tipo> findAll() {
		return tipoRepo.findAll();
	}

	@Override
	public Tipo save(Tipo tipo) {
		return tipoRepo.save(tipo);
	}

	@Override
	public void deleteById(Long id) {
		tipoRepo.deleteById(id);
	}

	
	
}
