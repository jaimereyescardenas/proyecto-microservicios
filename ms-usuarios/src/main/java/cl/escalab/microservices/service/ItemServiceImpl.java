package cl.escalab.microservices.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cl.escalab.microservices.client.EurekaClient;
import cl.escalab.microservices.dto.ItemDto;
import cl.escalab.microservices.dto.TipoDto;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private EurekaClient eureka;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
//	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	@HystrixCommand(fallbackMethod = "defaultItem")
	public ItemDto getRandomItem() {
		
		URI itemURI = eureka.getUri("SERVICIO-ITEM");
		ItemDto item = restTemplate.getForObject(itemURI.resolve("/api/random"), ItemDto.class);
		return item;
		
	}
	
	public ItemDto defaultItem() {
		return new ItemDto(1L,"Bulbasaur","Desc","imagen",new TipoDto(1L,"Común",0.5));
	}

}
