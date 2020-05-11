package it.corradodellorusso.devsearch.search;

/**
 * Builds search for <a href="https://google.com/" target="_blank">Google</a>
 */
public class GoogleFileSearch extends QueryParamSearch{

    private static final String QUERY_TEMPLATE = "https://google.com/search?q=%s";

    public GoogleFileSearch(String query) { super(query); }

    @Override
    protected String getQueryTemplate() { return QUERY_TEMPLATE; }
}
