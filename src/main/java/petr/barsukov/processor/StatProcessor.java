package petr.barsukov.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import petr.barsukov.types.Stat;
import petr.barsukov.service.StatService;

@Component
public class StatProcessor implements Processor {

    @Autowired
    private StatService service;

    @Override
    public void process(Exchange exchange) throws Exception {
        service.addStat(exchange.getIn().getBody(Stat.class));
    }
}
