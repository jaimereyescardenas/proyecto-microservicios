package cl.escalab.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.escalab.microservices.client.TipoFeignClient;
import cl.escalab.microservices.dto.TipoDto;

@Service
public class TipoServiceImpl implements TipoService {
	
	@Autowired
	private TipoFeignClient tipoClient;

	@Override
	public TipoDto getRandomTipo() {
		return tipoClient.getRandomTipo();
	}

}
