package boris.factura.service.impl;

import boris.factura.model.Factura;
import boris.factura.repository.FacturaRepository;
import boris.factura.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImplement extends GenericServiceImplement<Factura, Integer> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public JpaRepository<Factura, Integer> jpaRepository() {
        return facturaRepository;
    }
}

