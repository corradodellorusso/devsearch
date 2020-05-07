package it.corradodellorusso.devsearch.search;

public class DevToSearch extends QueryParamSearch {

    private static final String QUERY_TEMPLATE = "https://dev.to/search?q=%s";

    public DevToSearch(String query) {
        super(query);
    }

    @Override
    protected String getQueryTemplate() {
        return QUERY_TEMPLATE;
    }
}
