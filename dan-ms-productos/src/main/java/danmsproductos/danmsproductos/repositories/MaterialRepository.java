package danmsproductos.danmsproductos.repositories;

import org.springframework.stereotype.Repository;

import danmsproductos.danmsproductos.domain.Material;
import frsf.isi.dan.InMemoryRepository;

@Repository
public class MaterialRepository extends InMemoryRepository<Material>  {

    @Override
    public void deleteAllById(Iterable<? extends Integer> arg0) {}

    @Override
    public Integer getId(Material m) {
        return m.getId();
    }

    @Override
    public void setId(Material m, Integer id) {
        m.setId(id);
    }
    
}
