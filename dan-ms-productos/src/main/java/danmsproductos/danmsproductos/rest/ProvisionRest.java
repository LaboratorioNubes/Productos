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
import org.springframework.web.bind.annotation.RestController;

import danmsproductos.danmsproductos.domain.Provision;
import danmsproductos.danmsproductos.dtos.ProvisionDTO;
import danmsproductos.danmsproductos.services.ProvisionService;

@RestController
@RequestMapping(ProvisionRest.API_PROVISION)
public class ProvisionRest {
    static final String API_PROVISION = "/api/provision";
    
    @Autowired
    ProvisionService provService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Provision> provisionPorId(@PathVariable Integer id){
        return ResponseEntity.of(provService.buscarProvision(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Provision>> todos(){
        return ResponseEntity.ok(provService.buscarProvisiones());
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody ProvisionDTO nuevo){
        provService.guardarProvision(nuevo);
        return ResponseEntity.ok("Provision creada con exito.");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Provision> actualizar(@RequestBody ProvisionDTO nuevo,  @PathVariable Integer id) {
        return ResponseEntity.of(provService.actualizarProvision(nuevo, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Provision> borrar(@PathVariable Integer id){
        provService.borrarProvision(id);
        return ResponseEntity.ok().build();
    }
}