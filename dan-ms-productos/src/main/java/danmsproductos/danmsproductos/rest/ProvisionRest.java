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

import danmsproductos.danmsproductos.domain.Provision;

@RestController
@RequestMapping(ProvisionRest.API_PROVISION)
public class ProvisionRest {
    static final String API_PROVISION = "/api/provision";
    
    private static final List<Provision> listaProvisiones = new ArrayList<Provision>();
    private static Integer ID_GEN = 1;

    @GetMapping(path = "/{idProvision}")
    public ResponseEntity<Provision> provisionPorId(@PathVariable Integer idProvision){

        Optional<Provision> p =  listaProvisiones
                .stream()
                .filter(unaProvision -> unaProvision.getId().equals(idProvision))
                .findFirst();

        return ResponseEntity.of(p);
    }

    @GetMapping
    public ResponseEntity<List<Provision>> todos(){
        return ResponseEntity.ok(listaProvisiones);
    }

    @PostMapping
    public ResponseEntity<Provision> crear(@RequestBody Provision nuevo){
    	System.out.println("Crear provision "+ nuevo);
        nuevo.setId(ID_GEN++);
        listaProvisiones.add(nuevo);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping(path = "/{idProvision}")
    public ResponseEntity<Provision> actualizar(@RequestBody Provision nuevo,  @PathVariable Integer idProvision) {
        OptionalInt indexOpt =   IntStream.range(0, listaProvisiones.size())
        .filter(i -> listaProvisiones.get(i).getId().equals(idProvision))
        .findFirst();

        if(indexOpt.isPresent()){
            listaProvisiones.set(indexOpt.getAsInt(), nuevo);
            return ResponseEntity.ok(nuevo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{idProvision}")
    public ResponseEntity<Provision> borrar(@PathVariable Integer idProvision){
        OptionalInt indexOpt =   IntStream.range(0, listaProvisiones.size())
        .filter(i -> listaProvisiones.get(i).getId().equals(idProvision))
        .findFirst();

        if(indexOpt.isPresent()){
            listaProvisiones.remove(indexOpt.getAsInt());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}