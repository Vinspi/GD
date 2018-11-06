package tp.tpsparql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import tp.tpsparql.utils.SparqlReader;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

@Service
public class SparqlService {

    @Autowired
    ServletContext sc;

    private SparqlReader spqr;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        try {
            this.spqr = new SparqlReader(sc.getRealPath("/WEB-INF/aarhus_parking.ttl"));
            System.out.println("App ready");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }


    public String test(){

        System.out.println(sc.getResourcePaths("/WEB-INF/"));

        try {

            String query = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n" +
                    "prefix ct: <http://www.insight-centre.org/citytraffic#>\n" +
                    "prefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>\n" +
                    "SELECT ?nodeName ?value ?unit ?lat ?lon\n" +
                    "WHERE {\n" +
                    "    ?point a sao:Point;\n" +
                    "       sao:value ?value;\n" +
                    "       sao:hasUnitOfMeasurement ?unit;" +
                    "       ns1:featureOfInterest ?it." +
                    "       ?it ct:hasFirstNode _:node." +
                    "       _:node ct:hasLatitude ?lat." +
                    "       _:node ct:hasLongitude ?lon." +
                    "       _:node ct:hasNodeName ?nodeName." +
                    "}";



            return this.spqr.executeQuery(query);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "";

    }

}
