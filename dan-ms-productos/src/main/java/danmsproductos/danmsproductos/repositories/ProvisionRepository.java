package danmsproductos.danmsproductos.repositories;

import org.springframework.stereotype.Repository;

import danmsproductos.danmsproductos.domain.Provision;
import frsf.isi.dan.InMemoryRepository;


@Repository
public class ProvisionRepository extends InMemoryRepository<Provision> {

    @Override
    public Integer getId(Provision p) {
        return p.getId();
    }

    @Override
    public void setId(Provision p, Integer id) {
        p.setId(id);       
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> arg0) {}
    
}