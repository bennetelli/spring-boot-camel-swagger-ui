package com.schulz.bennet.springbootswagger;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class PersonRoute extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/person").get().outType(Person.class)
                .to("direct:talk");
        from("direct:talk")
                .process(exchange -> {
                    Person p = new Person();
                    p.setFirstname("Bennet");
                    p.setLastname("Schulz");
                    exchange.getIn().setBody(p);
                });
    }
}
