package tp.tpsparql.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.tpsparql.jsonRequests.DataRequest;
import tp.tpsparql.services.SparqlService;

import java.util.List;

@RestController
public class SparqlController {

    @Autowired
    SparqlService ss;

    @GetMapping("/")
    public String getAllData(){
        return ss.getAllData();
    }

    @PostMapping("/data")
    public String getData(@RequestBody DataRequest dr){
        return ss.getSomeData(dr);
    }

}
