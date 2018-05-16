package lt.vu.mif.knygynas.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped
@Alternative
public class GeneratorWithWord implements NameGenerator {
    private static Random random = new Random();

    protected String[] words = new String[] { "foo", "bar", "baz" };

    @Futureable
    public Future<String> generateNickname() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        final String generatedNickname = "author-" + words[random.nextInt(words.length)];
        return new AsyncResult<>(generatedNickname);
    }
}
