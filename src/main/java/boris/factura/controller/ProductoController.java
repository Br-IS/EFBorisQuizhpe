package boris.factura.controller;

import boris.factura.model.Factura;
import boris.factura.model.Producto;
import boris.factura.service.ProductoService;
import boris.factura.service.impl.ProductoServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.security.PrivateKey;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private ProductoServiceImplement productoServiceImplement;

    private Optional<Producto> productoOptional;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Producto producto) {

        if(producto.getProducto().equals("") || producto.getProducto().equals(null)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre del producto no puede estar vacio");
        }else  if (producto.getProducto().length()>25){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre del producto no puede ser mayor a 50 caracteres");
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body(productoServiceImplement.save(producto));
        }
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
        return StreamSupport.stream(productoServiceImplement.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Producto producto) {
        productoOptional = productoServiceImplement.findById(id);
        if (productoOptional.isPresent()) {
            productoOptional.get().setProducto(producto.getProducto());
            productoOptional.get().setPrecio(producto.getPrecio());
            productoOptional.get().setCantidad(producto.getCantidad());
            return ResponseEntity.status(HttpStatus.CREATED).body(productoServiceImplement.save(productoOptional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        productoOptional = productoServiceImplement.findById(id);
        if (productoOptional.isPresent()) {
            productoServiceImplement.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    ("/{id}")
    private ResponseEntity<Factura> asignarProductoFactura(@){

    }

    @Override
    public String toString() {
        return super.toString();
    }

    /*
    private ResponseEntity<Factura> getEstudianteResponseEntity(@PathVariable int idProducto, @PathVariable int id) {
        estudianteOptional = estudianteServiceImplement.findByID(idEstudiante);
        if (estudianteOptional.isPresent()) {
            cursoOptional = cursoServiceImplement.findByID(id);
            estudianteOptional.get().setCurso(
                    new Curso(cursoOptional.get().getId(),
                            cursoOptional.get().getParalelo(),
                            cursoOptional.get().getGrado(),
                            cursoOptional.get().getSeccion())
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(estudianteServiceImplement.save(estudianteOptional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/


}
