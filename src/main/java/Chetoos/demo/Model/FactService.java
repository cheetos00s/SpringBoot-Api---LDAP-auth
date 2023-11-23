package Chetoos.demo.Model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactService {
    
    @Autowired
    private FactRepo facRepo;

    public List<Factura> allFacturas(){
        return (List<Factura>) facRepo.findAll(); 
    }

    public Optional<Factura> singleFactura(Integer id){
        return facRepo.findById(id);
    }

    public void createFactura(Factura factura){
        facRepo.save(factura);
    }
}
