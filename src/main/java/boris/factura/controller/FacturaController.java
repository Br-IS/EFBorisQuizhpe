package boris.factura.controller;

import boris.factura.model.Factura;
import boris.factura.service.impl.FacturaServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Integer id) {
        facturaOptional = facturaServiceImplement.findById(id);
        if (facturaOptional.isPresent()) {
            return ResponseEntity.ok(facturaOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Factura> findAll() {
        return StreamSupport.stream(facturaServiceImplement.findAll().spliterator(), false).collect(Collectors.toList());
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
}
