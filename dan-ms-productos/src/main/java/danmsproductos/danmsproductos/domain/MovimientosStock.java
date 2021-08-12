package danmsproductos.danmsproductos.domain;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientosStock {
	
	private Integer id;
	private DetallePedido detallePedido;
	private DetalleProvision detalleProvision;
	private Material material;
	private Integer cantidadEntrada;
	private Integer cantidadSalida;
	private Instant fecha;
	
}