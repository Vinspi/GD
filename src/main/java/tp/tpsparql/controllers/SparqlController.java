package tp.tpsparql.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.tpsparql.services.SparqlService;

@RestController
public class SparqlController {

    @Autowired
    SparqlService ss;

    @GetMapping("/")
    public String getIndex(){
        return ss.test();
    }

}
