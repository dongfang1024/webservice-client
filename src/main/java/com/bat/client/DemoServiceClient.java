package com.bat.client;

import com.bat.wsdl.SayHello;
import com.bat.wsdl.SayHelloResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class DemoServiceClient extends WebServiceGatewaySupport {

    public SayHelloResponse response(){
        SayHello request = new SayHello(); //服务端的方法
        request.setUser("霍恩海姆"); //设置参数
        QName qName = new QName("http://service.bat.com", "sayHello");
        JAXBElement<SayHello> root = new JAXBElement<>(qName, SayHello.class, request);
        JAXBElement<SayHelloResponse> jxbElem = (JAXBElement<SayHelloResponse>) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8090/service/api?wsdl", root);
        return jxbElem.getValue();
    }

}
