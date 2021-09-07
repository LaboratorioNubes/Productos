package danmsproductos.danmsproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import danmsproductos.danmsproductos.domain.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
