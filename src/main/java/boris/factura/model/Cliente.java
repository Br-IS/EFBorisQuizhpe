package boris.factura.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;


    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;

    public Cliente() {
    }
}
