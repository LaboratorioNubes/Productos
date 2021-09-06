package danmsproductos.danmsproductos.repositories;

import danmsproductos.danmsproductos.domain.DetalleProvision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProvisionRepository extends JpaRepository<DetalleProvision, Integer> {
}
