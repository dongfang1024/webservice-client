package com.bat.config;

import com.bat.client.DemoServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        //this package must match the package in pom.xml
        marshaller.setContextPath("com.bat.wsdl");
        return marshaller;
    }

    @Bean
    public DemoServiceClient demoServiceClient(Jaxb2Marshaller marshaller){
        DemoServiceClient client = new DemoServiceClient();
        client.setDefaultUri("http://localhost:8090/service/api?wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
