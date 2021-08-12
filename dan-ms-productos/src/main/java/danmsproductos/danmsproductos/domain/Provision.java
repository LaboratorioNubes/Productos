package danmsproductos.danmsproductos.domain;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Provision {

	private Integer id;
	private Instant fechaProvision;
	private List<DetalleProvision> detalle;
	
}