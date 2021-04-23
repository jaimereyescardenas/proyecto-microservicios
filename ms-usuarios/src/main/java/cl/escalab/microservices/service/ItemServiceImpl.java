package cl.escalab.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cl.escalab.microservices.client.ItemFeignClient;
import cl.escalab.microservices.dto.ItemDto;
import cl.escalab.microservices.dto.TipoDto;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemFeignClient itemClient;

	@Override
	@HystrixCommand(fallbackMethod = "defaultItem", 
		commandProperties = {
				@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
				@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
				@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")}
	)
	public ItemDto getRandomItem() {
		
		return itemClient.getRandomItem();
		
	}
	
	public ItemDto defaultItem() {
		return new ItemDto(1L,"Bulbasaur","Desc","imagen",new TipoDto(1L,"Común",0.5));
	}

}
