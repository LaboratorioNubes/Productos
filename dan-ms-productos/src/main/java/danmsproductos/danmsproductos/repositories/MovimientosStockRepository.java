package danmsproductos.danmsproductos.repositories;

import danmsproductos.danmsproductos.domain.MovimientosStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosStockRepository extends JpaRepository<MovimientosStock, Integer>{
}
