package lt.vu.mif.knygynas.services;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.naming.Name;
import javax.transaction.Transactional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static javax.transaction.Transactional.TxType.REQUIRES_NEW;

@ApplicationScoped
@Decorator
public class GeneratorUppercase implements NameGenerator {
    @Delegate
    @Inject
    @Any
    NameGenerator nameGenerator;

    @Override
    @Transactional(REQUIRES_NEW)
    public CompletableFuture<String> generateNickname() {
        return nameGenerator.generateNickname().thenApply(String::toUpperCase);
    }
}
