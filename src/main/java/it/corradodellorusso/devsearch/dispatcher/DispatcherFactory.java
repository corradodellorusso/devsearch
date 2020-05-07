package it.corradodellorusso.devsearch.dispatcher;

import it.corradodellorusso.devsearch.search.Search;
import org.jetbrains.annotations.NotNull;

/**
 * Creates the right {@link Dispatcher} for a give {@link Search}.
 */
public class DispatcherFactory {

    /**
     * At the moment, only {@link WebDispatcher} is supported.
     * The param is therefore ignored.
     */
    @NotNull
    public static Dispatcher getDispatcherFor(Search search) {
        return new WebDispatcher();
    }

}
