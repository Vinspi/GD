package tp.tpsparql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import tp.tpsparql.jsonRequests.DataRequest;
import tp.tpsparql.utils.Coordinate;
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
    private SparqlReader temperature;
    private SparqlReader humidity;
    private SparqlReader pressure;
    private SparqlReader windSpeed;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        try {
            this.spqr = new SparqlReader(sc.getRealPath("/WEB-INF/aarhus_parking.ttl"));
            this.temperature = new SparqlReader(sc.getRealPath("/WEB-INF/temperature.ttl"));
            this.humidity = new SparqlReader(sc.getRealPath("/WEB-INF/humidity.ttl"));
            this.pressure = new SparqlReader(sc.getRealPath("/WEB-INF/pressure.ttl"));
            this.windSpeed = new SparqlReader(sc.getRealPath("/WEB-INF/wind_speed.ttl"));

            System.out.println("App ready");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public String getTemperature(String from, String to){

        try {
            String query = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n" +
                    "prefix ct: <http://www.insight-centre.org/citytraffic#>\n" +
                    "prefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>\n" +
                    "prefix tl: <http://purl.org/NET/c4dm/timeline.owl#>\n" +
                    "prefix xsd: <http://www.w3.org/2001/XMLSchema#>" +
                    "SELECT ?value ?unit ?time\n" +
                    "WHERE {\n" +
                    "    ?point a sao:Point;\n" +
                    "       sao:value ?value;\n" +
                    "       sao:hasUnitOfMeasurement ?unit;" +
                    "       sao:time _:time." +
                    "       _:time tl:at ?time." +
                    "       FILTER (?time <= \""+to+"\"^^xsd:dateTime && ?time >= \""+from+"\"^^xsd:dateTime)"+
                    "} LIMIT 50";


            return this.temperature.executeQuery(query);
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "";
    }

    public String getPressure(String from, String to){

        try {
            String query = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n" +
                    "prefix ct: <http://www.insight-centre.org/citytraffic#>\n" +
                    "prefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>\n" +
                    "prefix tl: <http://purl.org/NET/c4dm/timeline.owl#>\n" +
                    "prefix xsd: <http://www.w3.org/2001/XMLSchema#>" +
                    "SELECT ?value ?unit ?time\n" +
                    "WHERE {\n" +
                    "    ?point a sao:Point;\n" +
                    "       sao:value ?value;\n" +
                    "       sao:hasUnitOfMeasurement ?unit;" +
                    "       sao:time _:time." +
                    "       _:time tl:at ?time." +
                    "       FILTER (?time <= \""+to+"\"^^xsd:dateTime && ?time >= \""+from+"\"^^xsd:dateTime)"+
                    "} LIMIT 50";


            return this.pressure.executeQuery(query);
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "";
    }

    public String getHumidity(String from, String to){

        try {
            String query = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n" +
                    "prefix ct: <http://www.insight-centre.org/citytraffic#>\n" +
                    "prefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>\n" +
                    "prefix tl: <http://purl.org/NET/c4dm/timeline.owl#>\n" +
                    "prefix xsd: <http://www.w3.org/2001/XMLSchema#>" +
                    "SELECT ?value ?unit ?time\n" +
                    "WHERE {\n" +
                    "    ?point a sao:Point;\n" +
                    "       sao:value ?value;\n" +
                    "       sao:hasUnitOfMeasurement ?unit;" +
                    "       sao:time _:time." +
                    "       _:time tl:at ?time." +
                    "       FILTER (?time <= \""+to+"\"^^xsd:dateTime && ?time >= \""+from+"\"^^xsd:dateTime)"+
                    "} LIMIT 50";


            return this.humidity.executeQuery(query);
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "";
    }

    public String getWindSpeed(String from, String to){

        try {
            String query = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n" +
                    "prefix ct: <http://www.insight-centre.org/citytraffic#>\n" +
                    "prefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>\n" +
                    "prefix tl: <http://purl.org/NET/c4dm/timeline.owl#>\n" +
                    "prefix xsd: <http://www.w3.org/2001/XMLSchema#>" +
                    "SELECT ?value ?unit ?time\n" +
                    "WHERE {\n" +
                    "    ?point a sao:Point;\n" +
                    "       sao:value ?value;\n" +
                    "       sao:hasUnitOfMeasurement ?unit;" +
                    "       sao:time _:time." +
                    "       _:time tl:at ?time." +
                    "       FILTER (?time <= \""+to+"\"^^xsd:dateTime && ?time >= \""+from+"\"^^xsd:dateTime)"+
                    "} LIMIT 50";


            return this.windSpeed.executeQuery(query);
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "";
    }

    public String getAllGeoPoints() {


        try {
            String query = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n" +
                    "prefix ct: <http://www.insight-centre.org/citytraffic#>\n" +
                    "prefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>\n" +
                    "SELECT DISTINCT ?lat ?lon\n" +
                    "WHERE {\n" +
                    "    ?point a sao:Point;\n" +
                    "       ns1:featureOfInterest ?it." +
                    "       ?it ct:hasFirstNode _:node." +
                    "       _:node ct:hasLatitude ?lat." +
                    "       _:node ct:hasLongitude ?lon." +
                    "       _:node ct:hasNodeName ?nodeName." +
                    "}";

            return this.spqr.executeQuery(query);
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "";

    }

    public String getDataFromPoint(Coordinate<Double> c){
        try {
            String query = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n" +
                    "prefix ct: <http://www.insight-centre.org/citytraffic#>\n" +
                    "prefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>\n" +
                    "prefix tl: <http://purl.org/NET/c4dm/timeline.owl#>\n" +
                    "SELECT ?nodeName ?value ?unit ?time\n" +
                    "WHERE {\n" +
                    "    ?point a sao:Point;\n" +

                    "       sao:value ?value;\n" +
                    "       sao:hasUnitOfMeasurement ?unit;" +
                    "       ns1:featureOfInterest ?it." +
                    "       ?it ct:hasFirstNode _:node." +
                    "       _:node ct:hasLatitude ?lat." +
                    "       _:node ct:hasLongitude ?lon." +
                    "       _:node ct:hasNodeName ?nodeName." +
                    "     ?point sao:time _:time." +
                    "       _:time tl:at ?time." +
                    "       FILTER (?lat = "+c.getCoordX()+" && ?lon = "+c.getCoordY()+")"+
                    "} LIMIT 100";

            return this.spqr.executeQuery(query);
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "";
    }

    public String getAllData(){

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
                    "} LIMIT 30";



            return this.spqr.executeQuery(query);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "";

    }

    public String getSomeData(DataRequest dr){

        StringBuilder sb = new StringBuilder();

        sb.append("prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n");
        sb.append("prefix ct: <http://www.insight-centre.org/citytraffic#>\n");
        sb.append("prefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>\n");
        sb.append("SELECT ");

        for (String str : dr.getFields()){
            System.out.println(str);
            switch (str){
                case "name":
                    sb.append("?name ");
                    break;
                case "lon":
                    sb.append("?lon ");
                    break;
                case "lat":
                    sb.append("?lat ");
                    break;
                case "value":
                    sb.append("?value ?unit ");
                    break;
            }
        }

        sb.append("WHERE {\n" +
                "    ?point a sao:Point;\n" +
                "       sao:value ?value;\n" +
                "       sao:hasUnitOfMeasurement ?unit;" +
                "       ns1:featureOfInterest ?it." +
                "       ?it ct:hasFirstNode _:node." +
                "       _:node ct:hasLatitude ?lat." +
                "       _:node ct:hasLongitude ?lon." +
                "       _:node ct:hasNodeName ?nodeName." +
                "} ");

        if (dr.getLimit() != null){
            sb.append("LIMIT "+dr.getLimit());
        }


        try {
            return this.spqr.executeQuery(sb.toString());
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "";
    }

}
