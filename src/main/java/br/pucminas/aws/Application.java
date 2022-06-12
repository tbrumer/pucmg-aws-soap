package br.pucminas.aws;

import br.pucminas.aws.soap.CalculatorClient;
import br.pucminas.aws.wsdl.AddResponse;
import br.pucminas.aws.wsdl.DivideResponse;
import br.pucminas.aws.wsdl.MultiplyResponse;
import br.pucminas.aws.wsdl.SubtractResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner lookup(CalculatorClient quoteClient) {
        int a = 24;
        int b = 8;

        AddResponse adding = quoteClient.add(a, b);
        log.info("Adding result: {}", adding.getAddResult());
        SubtractResponse subtracting = quoteClient.subtract(a, b);
        log.info("Subtracting result: {}", subtracting.getSubtractResult());
        MultiplyResponse multiplying = quoteClient.multiply(a, b);
        log.info("Multiplying result: {}", multiplying.getMultiplyResult());
        DivideResponse dividing = quoteClient.divide(a, b);
        log.info("Dividing result: {}", dividing.getDivideResult());

        return args -> {
        };
    }

}
