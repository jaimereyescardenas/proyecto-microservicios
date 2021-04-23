package cl.escalab.microservices.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.escalab.microservices.dto.ItemDto;

@FeignClient(name = "servicio-item")
public interface ItemFeignClient {

	@GetMapping("/api/random")
	public ItemDto getRandomItem();
	
}
