package cl.escalab.microservices.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.escalab.microservices.dto.ItemDto;

@FeignClient(name = "servicio-item")
public interface ItemFeignClient {

	@GetMapping("/api//find/many/{ids}")
	public List<ItemDto> getItems(@PathVariable(name = "ids") List<Long> ids);
	
}
