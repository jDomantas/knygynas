package lt.vu.mif.knygynas.services;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@ApplicationScoped
@Specializes
public class GeneratorWithWordExtended extends GeneratorWithWord {
    @PostConstruct
    public void initWords() {
        words = new String[] { "lala", "lolo", "dobedobedo", "foobar" };
    }
}
