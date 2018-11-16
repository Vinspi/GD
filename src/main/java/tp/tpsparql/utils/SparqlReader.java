package tp.tpsparql.utils;


import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import java.io.*;

public class SparqlReader {

    private Model model;

    @Autowired
    ServletContext sc;

    public SparqlReader(String fileName) throws FileNotFoundException {

        this.model = ModelFactory.createDefaultModel();
        InputStream is = FileManager.get().open(fileName);


        if(is == null){
            throw new FileNotFoundException();
        }

        model.read(is, null,"TTL");
    }

    public String executeQuery(String q) throws UnsupportedEncodingException {


        OutputStream out = new ByteArrayOutputStream();
        String queryString = q;
        Query query = QueryFactory.create(queryString);
        QueryExecution qe = QueryExecutionFactory.create(query,this.model);
        ResultSet rs = qe.execSelect();
        ResultSetFormatter.outputAsJSON(out,rs);
        qe.close();

        return ((ByteArrayOutputStream) out).toString("UTF-8");
    }


}
