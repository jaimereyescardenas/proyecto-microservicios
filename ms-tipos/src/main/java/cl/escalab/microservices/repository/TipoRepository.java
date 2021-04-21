package cl.escalab.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.escalab.microservices.model.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {

}
