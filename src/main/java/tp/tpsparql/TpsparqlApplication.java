package tp.tpsparql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import tp.tpsparql.utils.SparqlReader;

import java.io.FileNotFoundException;

@SpringBootApplication
public class TpsparqlApplication {

    public static void main(String[] args) {



        SpringApplication.run(TpsparqlApplication.class, args);


    }
}
