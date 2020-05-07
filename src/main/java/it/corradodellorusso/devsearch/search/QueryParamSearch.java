package it.corradodellorusso.devsearch.search;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Builds URIs for all sites that just need an URL encoded query param to search.
 * An example would be a site like: mysite.com/q=<i>query</i>.
 * In case like this, inheritors just need to provide mysite.com/q=<i>%s</i>.
 * Use {@link MvnRepositorySearch} as an example.
 */
public abstract class QueryParamSearch implements Search {

    private final String query;

    public QueryParamSearch(String query) {
        this.query = query;
    }

    @Override
    public URI toURI() {
        String encode = URLEncoder.encode(query, StandardCharsets.UTF_8);
        return URI.create(String.format(getQueryTemplate(), encode));
    }

    /**
     * Implementors must provide query template with exactly one string parameter.
     * Example mysite.com/q=<i>%s</i>.
     */
    protected abstract String getQueryTemplate();

    public String getQuery() {
        return query;
    }

}
