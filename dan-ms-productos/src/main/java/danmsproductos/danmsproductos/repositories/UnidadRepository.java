package danmsproductos.danmsproductos.repositories;

import danmsproductos.danmsproductos.domain.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, Integer> {
}
