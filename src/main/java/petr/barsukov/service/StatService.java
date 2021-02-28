package petr.barsukov.service;

import org.springframework.stereotype.Service;
import petr.barsukov.types.Stat;

@Service
public class StatService {

    private Stat stat;

    public StatService() {

    }

    public void addStat(Stat content) {
        this.stat = content;
    }

    public Stat getStat() {
        return stat;
    }
}
