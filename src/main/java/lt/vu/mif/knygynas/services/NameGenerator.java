package lt.vu.mif.knygynas.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.transaction.Transactional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static javax.transaction.Transactional.TxType.REQUIRES_NEW;

public interface NameGenerator {
    @Futureable
    @Transactional(REQUIRES_NEW)
    CompletableFuture<String> generateNickname();
}
