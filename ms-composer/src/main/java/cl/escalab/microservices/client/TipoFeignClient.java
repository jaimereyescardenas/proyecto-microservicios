package cl.escalab.microservices.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.escalab.microservices.dto.TipoDto;

@FeignClient(name = "servicio-tipo")
public interface TipoFeignClient {

	@GetMapping("/api/list")
	public List<TipoDto> getTipos();
	
}
