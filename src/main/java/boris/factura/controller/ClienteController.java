package boris.factura.controller;

import boris.factura.model.Cliente;
import boris.factura.service.impl.ClienteServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteServiceImplement clienteServiceImplement;

    private Optional<Cliente> clienteOptional;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteServiceImplement.save(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Integer id) {
        clienteOptional = clienteServiceImplement.findById(id);
        if (clienteOptional.isPresent()) {
            return ResponseEntity.ok(clienteOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Cliente> findAll() {
        return StreamSupport.stream(clienteServiceImplement.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        clienteOptional = clienteServiceImplement.findById(id);
        if (clienteOptional.isPresent()) {
            clienteServiceImplement.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        clienteOptional = clienteServiceImplement.findById(id);
        if (clienteOptional.isPresent()) {
            clienteOptional.get().setNombre(cliente.getNombre());
            clienteOptional.get().setApellido(cliente.getApellido());
            clienteOptional.get().setTelefono(cliente.getTelefono());
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteServiceImplement.save(clienteOptional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}