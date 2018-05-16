package lt.vu.mif.knygynas.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped
public class NameGenerator {
    private static Random random = new Random();

    @Futureable
    public Future<String> generateNickname() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        final String generatedNickname = "author" + random.nextInt();
        return new AsyncResult<>(generatedNickname);
    }
}
