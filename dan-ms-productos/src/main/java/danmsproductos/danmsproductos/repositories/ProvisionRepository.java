package danmsproductos.danmsproductos.repositories;

import danmsproductos.danmsproductos.domain.Provision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvisionRepository extends JpaRepository<Provision, Integer> {
}
