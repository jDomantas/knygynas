package lt.vu.mif.knygynas.services;

import org.apache.deltaspike.core.api.future.Futureable;

import java.util.concurrent.Future;

public interface NameGenerator {
    @Futureable
    Future<String> generateNickname();
}
