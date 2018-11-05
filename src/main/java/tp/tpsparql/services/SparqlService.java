package tp.tpsparql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.tpsparql.utils.SparqlReader;

import javax.servlet.ServletContext;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

@Service
public class SparqlService {

    @Autowired
    ServletContext sc;



    public String test(){

        System.out.println(sc.getResourcePaths("/WEB-INF/"));

        try {
            SparqlReader sr = new SparqlReader(sc.getRealPath("/WEB-INF/aarhus_parking.ttl"));

            String query = "PREFIX ct: <http://www.insight-centre.org/citytraffic>" +
                    "SELECT * " +
                    "WHERE { ?x ?name" +
                    "?x ct:hasNodeName ?name" +
                    "}" +
                    "LIMIT 10";



            return sr.executeQuery(query);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "";

    }

}
