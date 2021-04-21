package cl.escalab.microservices.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cl.escalab.microservices.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, Long> {
	
	public List<Item> findByIdTipo(Long idTipo);

}
