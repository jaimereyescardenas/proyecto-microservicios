package cl.escalab.microservices.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.escalab.microservices.dto.ItemComposeDto;
import cl.escalab.microservices.dto.TipoDto;
import cl.escalab.microservices.model.Item;
import cl.escalab.microservices.repository.ItemRepository;
import cl.escalab.microservices.service.SequenceGeneratorService;
import cl.escalab.microservices.service.TipoService;

@RestController
@RequestMapping("/api")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private TipoService tipoService;

	@Autowired
	private SequenceGeneratorService seqService;
	
	@GetMapping({"/", "/health"})
	public String health() {
		return "Todo OK";
	}
	
	@PostMapping("/save")
	public Item createItem(@RequestBody Item item) {
		
		if (item == null) {
			// TODO BadRequestException
		}
		
		Item i = item;
		i.setId(seqService.generateSequence(Item.SEQUENCE_NAME));
		Item savedItem = itemRepository.save(i);
		return savedItem;
	}
	
	@GetMapping("/list")
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
	
	@GetMapping("/find/id/{id}")
	public Item getItemById(@PathVariable(name = "id") Long id) {
		
		if (id <= 0) {
			// TODO BadRequestException
		}
		
		Optional<Item> item = itemRepository.findById(id);
		
		if (!item.isPresent()) {
			// TODO NotFoundException
		}
		
		return item.get();
	}
	
	@GetMapping("/find/tipo/{id}")
	public List<Item> getItemByTipo(@PathVariable(name = "id") Long id) {
		
		if (id <= 0) {
			// TODO BadRequestException
		}
		
		List<Item> items = itemRepository.findByIdTipo(id);
		return items;
		
	}
	
	@GetMapping("/find/many/{ids}")
	public List<Item> getItemsById(@PathVariable(name = "ids") List<Long> ids) {
		
		if (ids.size() == 0) {
			// TODO BadRequestException
		}
		
		List<Item> items = (List<Item>) itemRepository.findAllById(ids);
		return items;
		
	}
	
	@PutMapping("/edit/{id}")
	public Item edit(@PathVariable(name = "id") Long id, @RequestBody Item item) {
		
		if (id != item.getId()) {
			// TODO BadRequestException
		}
		
		Item modifiedItem = itemRepository.save(item);
		return modifiedItem;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public Item delete(@PathVariable(name = "id") Long id) {
		
		Optional<Item> item = itemRepository.findById(id);
		
		if (!item.isPresent()) {
			// TODO NotFoundException
		}
		
		itemRepository.deleteById(id);
		return item.get();
		
	}
	
	@GetMapping("/random")
	public ItemComposeDto getRandomItem() {
		
		TipoDto tipo = tipoService.getRandomTipo();
		List<Item> items = itemRepository.findByIdTipo(tipo.getId());
		
		int randomItemId = (int) (Math.random() * items.size());
		Item randomItem = items.get(randomItemId);
		
		ItemComposeDto itemDto = new ItemComposeDto();
		itemDto.setId(randomItem.getId());
		itemDto.setNombre(randomItem.getNombre());
		itemDto.setDescripcion(randomItem.getDescripcion());
		itemDto.setUrlImagen(randomItem.getUrlImagen());
		itemDto.setTipo(tipo);
		
		return itemDto;
	}
	
}
