package cl.escalab.microservices.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.escalab.microservices.dto.TipoDto;

@FeignClient(name = "servicio-tipo")
public interface TipoFeignClient {

	@GetMapping("/api/random")
	public TipoDto getRandomTipo();
	
}
