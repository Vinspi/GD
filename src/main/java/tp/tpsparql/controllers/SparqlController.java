package tp.tpsparql.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.tpsparql.jsonRequests.DataRequest;
import tp.tpsparql.services.SparqlService;
import tp.tpsparql.utils.Coordinate;

import javax.servlet.ServletContext;

@RestController
public class SparqlController {

    @Autowired
    SparqlService ss;



    @GetMapping("/points")
    @CrossOrigin
    public String getAllGeoPoints(){
        return ss.getAllGeoPoints();
    }

    @GetMapping("/pointData")
    @CrossOrigin
    public String getPointData(@RequestParam(value = "lat") double coordx, @RequestParam(value = "lon") double coordy){
        return ss.getDataFromPoint(new Coordinate<>(coordx,coordy));
    }

    @PostMapping("/data")
    @CrossOrigin
    public String getData(@RequestBody DataRequest dr){
        return ss.getSomeData(dr);
    }

    @GetMapping("/getTemperature")
    @CrossOrigin
    public String getTemperature(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to){


        return ss.getTemperature(from, to);
    }

    @GetMapping("/getPressure")
    @CrossOrigin
    public String getPressure(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to){


        return ss.getPressure(from, to);
    }

    @GetMapping("/getHumidity")
    @CrossOrigin
    public String getHumidity(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to){


        return ss.getHumidity(from, to);
    }

    @GetMapping("/getWindSpeed")
    @CrossOrigin
    public String getWindSpeed(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to){


        return ss.getWindSpeed(from, to);
    }

//    @GetMapping("/test")
//    @CrossOrigin
//    public String getContextPatht(){
//        return sc.getContextPath();
//    }

}
