package Chetoos.demo.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactRepo extends CrudRepository<Factura, Integer>{
    
}

