package boris.factura.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "producto")
@Data
@AllArgsConstructor
public class Producto implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
   @Column(name = "id_producto", nullable = false)
    private Integer idProducto;


    private String cod_producto;
    private String producto;
    private Integer cantidad;
    private Double precio;


    public Producto() {
    }


    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;

}
