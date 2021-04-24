package cl.escalab.microservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.escalab.microservices.dto.TipoProbDto;
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

	@Override
	public Tipo getRandom() {
		
		List<Tipo> tipos = tipoRepo.findAll();
		List<TipoProbDto> auxTipos = new ArrayList<>();
		Double accumulatedProb = 0d;
		
		for (Tipo t: tipos) {
			TipoProbDto tProb = new TipoProbDto();
			tProb.setId(t.getId());
			accumulatedProb += t.getProbabilidad();
			tProb.setProb(accumulatedProb);
			auxTipos.add(tProb);
		}
		
		Random r = new Random();
		Double randomNumber = r.nextDouble();
		
		Tipo randomTipo = new Tipo();
		
		for (TipoProbDto tpd: auxTipos) {
			if (randomNumber < tpd.getProb()) {
				randomTipo = tipos.stream()
						.filter(t -> t.getId() == tpd.getId())
						.collect(Collectors.toList())
						.get(0);
				break;
			}
		}
		
		return randomTipo;
	}

	
	
}
