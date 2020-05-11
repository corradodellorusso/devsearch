package it.corradodellorusso.devsearch.search;

/**
 * Builds search for <a href="https://www.npmjs.com/" target="_blank">NPM</a>
 */
public class NpmSearch extends QueryParamSearch {

    private static final String QUERY_TEMPLATE = "https://www.npmjs.com/search?q=%s";

    public NpmSearch(String query) {
        super(query);
    }

    @Override
    protected String getQueryTemplate() {
        return QUERY_TEMPLATE;
    }

}
