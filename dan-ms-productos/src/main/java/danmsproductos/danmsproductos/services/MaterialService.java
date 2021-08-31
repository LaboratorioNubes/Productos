package danmsproductos.danmsproductos.services;

import java.util.Optional;

import danmsproductos.danmsproductos.domain.Material;
import danmsproductos.danmsproductos.dtos.MaterialDTO;

public interface MaterialService {

    public Optional<Material> buscarMaterial(Integer id);
    public Iterable<Material> buscarMateriales();
    
    public Material guardarMaterial(MaterialDTO p);
    public Optional<Material> actualizarMaterial(MaterialDTO p, Integer id);
    public void borrarMaterial(Integer id);
    public Optional buscarMaterialPorPrecio(Integer price);
    public Optional buscarMaterialPorRango(Integer min, Integer max);
    
}
