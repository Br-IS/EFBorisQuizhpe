package boris.factura.service.impl;

import boris.factura.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public abstract class GenericServiceImplement<T, ID> implements GenericService<T, ID>, Serializable {

    @Autowired
    public abstract JpaRepository<T, ID> jpaRepository();


    @Override
    public T save(T t) {
        return jpaRepository().save(t);
    }

    @Override
    public Iterable<T> findAll() {
        return jpaRepository().findAll();
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository().deleteById(id);
    }


    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository().findById(id);
    }
}

