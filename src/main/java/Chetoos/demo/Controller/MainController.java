package Chetoos.demo.Controller;

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

    public ResponseEntity<String> createFactura(@RequestBody Factura factura) {
        factService.createFactura(factura);
        return new ResponseEntity<>("Factura creada exitosamente", HttpStatus.CREATED);
    }


}

