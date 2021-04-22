package cl.escalab.microservices.service;

import cl.escalab.microservices.dto.ItemDto;
import cl.escalab.microservices.dto.TipoDto;

public class ItemServiceImpl implements ItemService {

	@Override
	public ItemDto getRandomItem() {
		// TODO Conectar con ms-items a través de API
		return new ItemDto(1L,"Bulbasaur","Desc","imagen",new TipoDto(1L,"Común",0.5));
	}

}
