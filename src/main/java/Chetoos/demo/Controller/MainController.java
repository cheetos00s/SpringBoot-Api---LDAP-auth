package Chetoos.demo.Controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Chetoos.demo.Model.PaisRepo;
import Chetoos.demo.Model.pais;

@RestController
@ComponentScan("Chetoos.demo.controller")
public class MainController {

    private PaisRepo paisRepo;

    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("HOME PAGE XD %s!", name);
    }

    @PostMapping(path = "/add")// Map ONLY POST Requests
    public @ResponseBody String addPais(@RequestParam String Nombre){
      // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

      pais p = new pais();
      p.setNOMBRE_PAIS(Nombre);
      p.setESTADO_PAIS('d');
      paisRepo.save(p);

      return "Saved";

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<pais> getAllPais(){
      //This returns a JSON or XML with the users
      return paisRepo.findAll();
    }

}

