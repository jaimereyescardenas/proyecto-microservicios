package cl.escalab.microservices.composer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.escalab.microservices.client.ItemFeignClient;
import cl.escalab.microservices.client.TipoFeignClient;
import cl.escalab.microservices.client.UsuarioFeignClient;
import cl.escalab.microservices.dto.ItemComposeDto;
import cl.escalab.microservices.dto.ItemDto;
import cl.escalab.microservices.dto.TipoDto;
import cl.escalab.microservices.dto.UsuarioComposeDto;
import cl.escalab.microservices.dto.UsuarioDto;

@Service
public class ResponseComposer {
	
	@Autowired
	private TipoFeignClient tipoClient;
	
	@Autowired
	private ItemFeignClient itemClient;
	
	@Autowired
	private UsuarioFeignClient usuarioClient;

	
	public UsuarioComposeDto getUsuarioItems(Long idUsuario) {
		
		UsuarioDto usuarioDto = usuarioClient.getUsuarioDetails(idUsuario);
		List<ItemDto> items = itemClient.getItems(usuarioDto.getItems());
		List<TipoDto> tipos = tipoClient.getTipos();
		
		UsuarioComposeDto ucd = new UsuarioComposeDto();
		ucd.setId(usuarioDto.getId());
		ucd.setNombre(usuarioDto.getNombre());
		ucd.setEmail(usuarioDto.getEmail());
		
		List<ItemComposeDto> composedItems = new ArrayList<>();
		
		for (ItemDto item: items) {
			
			ItemComposeDto icd = new ItemComposeDto();
			icd.setId(item.getId());
			icd.setNombre(item.getNombre());
			icd.setDescripcion(item.getDescripcion());
			icd.setUrlImagen(item.getUrlImagen());
			
			TipoDto tipo = tipos.stream()
					.filter(t -> t.getId() == item.getIdTipo())
					.collect(Collectors.toList())
					.get(0);
			
			icd.setTipo(tipo);
			
			composedItems.add(icd);
			
		}
		
		ucd.setItems(composedItems);
		
		return ucd;
	}
	
	public UsuarioComposeDto defaultUsuario(Long idUsuario) {
		return new UsuarioComposeDto();
	}
	
}
