package danmsproductos.danmsproductos.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import danmsproductos.danmsproductos.domain.Material;
import danmsproductos.danmsproductos.dtos.MaterialDTO;
import danmsproductos.danmsproductos.repositories.MaterialRepository;
import danmsproductos.danmsproductos.services.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialRepository materialRepo;

    Material matNuevo;

    @Override
    public Optional<Material> buscarMaterial(Integer id) {
        return this.materialRepo.findById(id);
    }

    @Override
    public Iterable<Material> buscarMateriales() {
        return this.materialRepo.findAll();
    }

    @Override
    public Material guardarMaterial(MaterialDTO p) {
        matNuevo = new Material();
        // TODO setear datos
        return null;
    }

    @Override
    public Optional<Material> actualizarMaterial(MaterialDTO p, Integer id) {
        // TODO Not possible without bdd
        return null;
    }

    @Override
    public void borrarMaterial(Integer id) {
        this.materialRepo.deleteById(id);
    }
    
}
