package boris.factura.controller;

import boris.factura.model.Producto;
import boris.factura.service.ProductoService;
import boris.factura.service.impl.ProductoServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.security.PrivateKey;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private ProductoServiceImplement productoServiceImplement;

    private Optional<Producto> productoOptional;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoServiceImplement.save(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Integer id) {
        productoOptional = productoServiceImplement.findById(id);
        if (productoOptional.isPresent()) {
            return ResponseEntity.ok(productoOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Producto> findAll() {
        return StreamSupport.stream(facturaServiceImplement.findAll().spliterator(), false).collect(Collectors.toList());
    }

}


/*

@RestController
@RequestMapping("/api/factura")
public class FacturaController {
    @Autowired
    private FacturaServiceImplement facturaServiceImplement;

    private Optional<Factura> facturaOptional;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Factura factura) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaServiceImplement.save(factura));
    }



    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        facturaOptional = facturaServiceImplement.findById(id);
        if (facturaOptional.isPresent()) {
            facturaServiceImplement.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 */