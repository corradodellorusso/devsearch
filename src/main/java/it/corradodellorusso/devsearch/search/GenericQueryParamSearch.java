package it.corradodellorusso.devsearch.search;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public abstract class GenericQueryParamSearch implements Search {

    private final String query;

    public GenericQueryParamSearch(String query) {
        this.query = query;
    }

    @Override
    public URI toURI() {
        String encode = URLEncoder.encode(query, StandardCharsets.UTF_8);
        return String.format(getQueryTemplate(), encode);
    }

    protected abstract String getQueryTemplate();

    public String getQuery() {
        return query;
    }

}
