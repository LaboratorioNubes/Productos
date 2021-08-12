package danmsproductos.danmsproductos.dtos;

import java.time.Instant;
import java.util.List;

import danmsproductos.danmsproductos.domain.DetalleProvision;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvisionDTO {
	private Integer id;
	private Instant fechaProvision;
	private List<DetalleProvision> detalle;
}