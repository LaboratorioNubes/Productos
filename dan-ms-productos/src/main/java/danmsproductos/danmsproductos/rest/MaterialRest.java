package danmsproductos.danmsproductos.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import danmsproductos.danmsproductos.domain.Material;



@RestController
@RequestMapping(MaterialRest.API_MATERIAL)
public class MaterialRest {
    static final String API_MATERIAL = "/api/material";
    
    private static final List<Material> listaMateriales = new ArrayList<Material>();
    private static Integer ID_GEN = 1;

    @GetMapping(path = "/{idMaterial}")
    public ResponseEntity<Material> materialPorId(@PathVariable Integer idMaterial){

        Optional<Material> m =  listaMateriales
                .stream()
                .filter(unMaterial -> unMaterial.getId().equals(idMaterial))
                .findFirst();

        return ResponseEntity.of(m);
    }

    @GetMapping
    public ResponseEntity<List<Material>> todos(){
        return ResponseEntity.ok(listaMateriales);
    }

    @PostMapping
    public ResponseEntity<Material> crear(@RequestBody Material nuevo){
    	System.out.println("Crear material "+ nuevo);
        nuevo.setId(ID_GEN++);
        listaMateriales.add(nuevo);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping(path = "/{idMaterial}")
    public ResponseEntity<Material> actualizar(@RequestBody Material nuevo,  @PathVariable Integer idMaterial) {
        OptionalInt indexOpt =   IntStream.range(0, listaMateriales.size())
        .filter(i -> listaMateriales.get(i).getId().equals(idMaterial))
        .findFirst();

        if(indexOpt.isPresent()){
            listaMateriales.set(indexOpt.getAsInt(), nuevo);
            return ResponseEntity.ok(nuevo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{idMaterial}")
    public ResponseEntity<Material> borrar(@PathVariable Integer idMaterial){
        OptionalInt indexOpt =   IntStream.range(0, listaMateriales.size())
        .filter(i -> listaMateriales.get(i).getId().equals(idMaterial))
        .findFirst();

        if(indexOpt.isPresent()){
            listaMateriales.remove(indexOpt.getAsInt());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}