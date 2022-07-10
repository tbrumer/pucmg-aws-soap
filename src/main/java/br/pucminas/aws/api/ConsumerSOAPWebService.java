package br.pucminas.aws.api;

import br.pucminas.aws.soap.CalculatorClient;
import br.pucminas.aws.wsdl.AddResponse;
import br.pucminas.aws.wsdl.DivideResponse;
import br.pucminas.aws.wsdl.MultiplyResponse;
import br.pucminas.aws.wsdl.SubtractResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@Slf4j
@RestController
@RequestMapping("calculate/")
public class ConsumerSOAPWebService {
    @Autowired
    CalculatorClient quoteClient;

    @GetMapping("soma")
    ResponseEntity somar(@RequestParam Integer numberOne, @RequestParam Integer numberTwo){
        return ResponseEntity.ok(quoteClient.add(numberOne, numberTwo));
    }

    @GetMapping("subtrai")
    ResponseEntity subtrair(@RequestParam Integer numberOne, @RequestParam Integer numberTwo){
        return ResponseEntity.ok(quoteClient.subtract(numberOne, numberTwo));
    }

    @GetMapping("multiplica")
    ResponseEntity multiplicar(@RequestParam Integer numberOne, @RequestParam Integer numberTwo){
        return ResponseEntity.ok(quoteClient.multiply(numberOne, numberTwo));
    }

    @GetMapping("divide")
    ResponseEntity dividir(@RequestParam Integer numberOne, @RequestParam Integer numberTwo){
        return ResponseEntity.ok(quoteClient.divide(numberOne, numberTwo));
    }

}
