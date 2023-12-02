package Chetoos.demo.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Chetoos.demo.Model.FactService;
import Chetoos.demo.Model.Factura;
@RestController
@ComponentScan("Chetoos.demo.controller")
@RequestMapping("/items")
public class MainController {

    @Autowired
    private FactService factService;

    @GetMapping("/facturas")
    public ResponseEntity<List<Factura>> getAllFacturas(){
        return new ResponseEntity<List<Factura>>(factService.allFacturas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Factura>> getSingleFactura(@PathVariable Integer id){
      return new ResponseEntity<Optional<Factura>>(factService.singleFactura(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewFactura(@RequestBody Factura facturaRequest) {
        // facturaRequest es un objeto Java que mapea la estructura del JSON
        // Puedes acceder a sus propiedades para obtener los datos de la factura
        try{
            Factura nuevaFactura = new Factura();
            System.out.println(facturaRequest + "                             12");
            nuevaFactura.setFechaFactura(facturaRequest.getFechaFactura());
            System.out.println(nuevaFactura + "                               34");
            nuevaFactura.setIdTipoFac(facturaRequest.getIdTipoFac());
            nuevaFactura.setClienteFactura(facturaRequest.getClienteFactura());
            nuevaFactura.setTotalFactura(facturaRequest.getTotalFactura());
            nuevaFactura.setDescuentoFactura(facturaRequest.getDescuentoFactura());
            nuevaFactura.setIvaFactura(facturaRequest.getIvaFactura());
            nuevaFactura.setSubtotalFactura(facturaRequest.getSubtotalFactura());
            nuevaFactura.setSaldoFactura(facturaRequest.getSaldoFactura());
            nuevaFactura.setEstadoFactura(facturaRequest.getEstadoFactura());
            System.out.println(nuevaFactura + "                                45");
            // Guarda la nueva factura en el repositorio
            factService.createFactura(nuevaFactura);
        }catch(Error e){
            return new ResponseEntity<>( "Puta mierda" , HttpStatus.BAD_REQUEST);
        }
        
    
        return new ResponseEntity<>("Factura guardada exitosamente", HttpStatus.CREATED);
    }


}

