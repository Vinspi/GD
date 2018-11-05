package tp.tpsparql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tp.tpsparql.utils.SparqlReader;

import java.io.FileNotFoundException;

@SpringBootApplication
public class TpsparqlApplication {

    public static void main(String[] args) {



        SpringApplication.run(TpsparqlApplication.class, args);
    }
}
