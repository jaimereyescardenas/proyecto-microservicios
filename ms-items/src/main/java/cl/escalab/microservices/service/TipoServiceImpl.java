package cl.escalab.microservices.service;

import org.springframework.stereotype.Service;

import cl.escalab.microservices.dto.TipoDto;

@Service
public class TipoServiceImpl implements TipoService {

	@Override
	public TipoDto getRandomTipo() {
		// TODO Conectar con API
		return new TipoDto(1L,"Común",0.5);
	}

}
