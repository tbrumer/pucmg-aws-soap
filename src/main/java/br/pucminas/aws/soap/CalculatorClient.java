package br.pucminas.aws.soap;

import br.pucminas.aws.wsdl.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class CalculatorClient extends WebServiceGatewaySupport {

    private static final String CALCULATOR_URI = "http://www.dneonline.com/calculator.asmx";

    public AddResponse add(int a, int b) {
        Add request = new Add();

        request.setIntA(a);
        request.setIntB(b);

        log.info("Requesting result for {}+{}...", a, b);

        return (AddResponse) getWebServiceTemplate().marshalSendAndReceive(
                CALCULATOR_URI,
                request,
                new SoapActionCallback("http://tempuri.org/Add")
        );
    }

    public SubtractResponse subtract(int a, int b) {
        Subtract request = new Subtract();

        request.setIntA(a);
        request.setIntB(b);

        log.info("Requesting result for {}-{}...", a, b);

        return (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(
                CALCULATOR_URI,
                request,
                new SoapActionCallback("http://tempuri.org/Subtract")
        );
    }

    public MultiplyResponse multiply(int a, int b) {
        Multiply request = new Multiply();

        request.setIntA(a);
        request.setIntB(b);

        log.info("Requesting result for {}*{}...", a, b);

        return (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(
                CALCULATOR_URI,
                request,
                new SoapActionCallback("http://tempuri.org/Multiply")
        );
    }

    public DivideResponse divide(int a, int b) {
        Divide request = new Divide();

        request.setIntA(a);
        request.setIntB(b);

        log.info("Requesting result for {}/{}...", a, b);

        return (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(
                CALCULATOR_URI,
                request,
                new SoapActionCallback("http://tempuri.org/Divide")
        );
    }

}
