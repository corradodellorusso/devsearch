package it.corradodellorusso.devsearch.search;

import java.net.URI;

/**
 * Representation of a search.
 * Implementors of this interface are able to build URIs for resources the search looks for.
 * For example, if we need to implement a GoogleSearch, implementor must be able to create URIs to search there.
 */
public interface Search {

    /**
     * Returns the URI for the resource we're looking for.
     *
     * @return the URI.
     */
    URI toURI();

}
