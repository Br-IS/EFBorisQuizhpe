package boris.factura.service.impl;

import boris.factura.model.Producto;
import boris.factura.repository.ProductoRepository;
import boris.factura.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImplement extends GenericServiceImplement<Producto, Integer> implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public JpaRepository<Producto, Integer> jpaRepository() {
        return productoRepository;
    }
}

