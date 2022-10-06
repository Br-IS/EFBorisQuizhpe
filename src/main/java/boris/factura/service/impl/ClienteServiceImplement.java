package boris.factura.service.impl;

import boris.factura.model.Cliente;
import boris.factura.repository.ClienteRepository;
import boris.factura.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImplement extends GenericServiceImplement<Cliente, Integer> implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public JpaRepository<Cliente, Integer> jpaRepository() {
        return clienteRepository;
    }
}