package danmsproductos.danmsproductos.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import danmsproductos.danmsproductos.domain.Provision;
import danmsproductos.danmsproductos.dtos.ProvisionDTO;
import danmsproductos.danmsproductos.repositories.ProvisionRepository;
import danmsproductos.danmsproductos.services.ProvisionService;

public class ProvisionServiceImpl implements ProvisionService {
    
    @Autowired
    ProvisionRepository provisionRepo;

    Provision provNuevo;

    @Override
    public Optional<Provision> buscarProvision(Integer id) {
        return this.provisionRepo.findById(id);
    }

    @Override
    public Iterable<Provision> buscarProvisiones() {
        return this.provisionRepo.findAll();
    }

    @Override
    public Provision guardarProvision(ProvisionDTO p) {
        provNuevo = new Provision();
        // TODO setear dto data
        return provNuevo;
    }

    @Override
    public Optional<Provision> actualizarProvision(ProvisionDTO p, Integer id) {
        // TODO not possible without bdd
        return null;
    }

    @Override
    public void borrarProvision(Integer id) {
        this.provisionRepo.deleteById(id);
    }

}
