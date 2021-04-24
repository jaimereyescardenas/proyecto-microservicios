package cl.escalab.microservices.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.escalab.microservices.dto.UsuarioDto;

@FeignClient(name = "servicio-usuario")
public interface UsuarioFeignClient {

	@GetMapping("/api/details/{id}")
	public UsuarioDto getUsuarioDetails(@PathVariable(name = "id") Long id);
	
}
