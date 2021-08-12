package danmsproductos.danmsproductos.services;

import java.util.Optional;

import danmsproductos.danmsproductos.domain.Provision;
import danmsproductos.danmsproductos.dtos.ProvisionDTO;

public interface ProvisionService {
    
    public Optional<Provision> buscarProvision(Integer id);
    public Iterable<Provision> buscarProvisiones();
    
    public Provision guardarProvision(ProvisionDTO p);
    public Optional<Provision> actualizarProvision(ProvisionDTO p, Integer id);
    public void borrarProvision(Integer id);
}
