package danmsproductos.danmsproductos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import danmsproductos.danmsproductos.domain.Material;
import danmsproductos.danmsproductos.dtos.MaterialDTO;
import danmsproductos.danmsproductos.services.MaterialService;

@RestController
@RequestMapping(MaterialRest.API_MATERIAL)
public class MaterialRest {
    static final String API_MATERIAL = "/api/material";
    
    @Autowired
    MaterialService materialService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Material> materialPorId(@PathVariable Integer id){
        return ResponseEntity.of(materialService.buscarMaterial(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Material>> todos(){
        return ResponseEntity.ok(materialService.buscarMateriales());
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody MaterialDTO nuevo){
        materialService.guardarMaterial(nuevo);
        return ResponseEntity.ok("Material creado con exito");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Material> actualizar(@RequestBody MaterialDTO nuevo,  @PathVariable Integer id) {
       return ResponseEntity.of(materialService.actualizarMaterial(nuevo, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Material> borrar(@PathVariable Integer id){
        materialService.borrarMaterial(id);
        return ResponseEntity.ok().build();
    }

    // Consultar por nombre
    @GetMapping(path = "/range")
    @ResponseBody
    public ResponseEntity<Iterable<Material>>materialPorRango(
        @RequestParam(required = true) Integer min, @RequestParam(required = true) Integer max){
        return ResponseEntity.of(materialService.buscarMaterialPorRango(min, max));
    }
    
    @GetMapping(path = "/precio")
    @ResponseBody
    public ResponseEntity<Material> materialPorPrecio(@RequestParam(required = true) Integer price){
        return ResponseEntity.of(materialService.buscarMaterialPorPrecio(price));
    }
}