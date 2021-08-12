package danmsproductos.danmsproductos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedido {
	private Integer id;
	private Material material;
	private Integer cantidad;
}