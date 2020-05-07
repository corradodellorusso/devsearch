package it.corradodellorusso.devsearch.dispatcher;

import it.corradodellorusso.devsearch.search.Search;

/**
 * Implementors of this interface are in charge of dispatching different type of {@link Search} in the right way.
 * An example of dispatching would be opening in a browser a search which has a http or https content.
 */
public interface Dispatcher {

    /**
     * Actually dispatches the search.
     * @param search to be dispatched.
     */
    void dispatch(Search search);

}
