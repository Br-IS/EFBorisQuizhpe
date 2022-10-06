package boris.factura.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "factura")
@Data
@AllArgsConstructor
public class Factura  implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idFactura", nullable = false)
    private Integer idFactura;

    public Factura() {
    }

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;



}
