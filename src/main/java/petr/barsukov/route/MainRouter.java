package petr.barsukov.route;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import petr.barsukov.processor.StatProcessor;
import petr.barsukov.service.StatService;
import petr.barsukov.types.Stat;


@Component
public class MainRouter extends RouteBuilder {

    @Autowired
    private StatService service;

    @BeanInject
    private StatProcessor statProcessor;

    @Override
    public void configure() {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);


        rest()
                .get("/stat")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .outType(Stat.class)
                .route()
                .setBody(() -> service.getStat())
                .endRest();

        from("file://C:/projects/camel_rest/?fileName=pom.xml&charset=utf-8&noop=true")
                .bean("searcher", "searchAndReturn")
                .process(statProcessor);
    }
}
