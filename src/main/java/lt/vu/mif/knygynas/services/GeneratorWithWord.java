package lt.vu.mif.knygynas.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.transaction.Transactional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static javax.transaction.Transactional.TxType.REQUIRES_NEW;

@ApplicationScoped
@Alternative
public class GeneratorWithWord implements NameGenerator {
    private static Random random = new Random();

    protected String[] words = new String[] { "foo", "bar", "baz" };

    @Futureable
    @Transactional(REQUIRES_NEW)
    public CompletableFuture<String> generateNickname() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        final String generatedNickname = "author-" + words[random.nextInt(words.length)];
        return CompletableFuture.completedFuture(generatedNickname);
    }
}
