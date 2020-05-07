package it.corradodellorusso.devsearch.search;

/**
 * Builds search for <a href="https://mvnrepository.com/" target="_blank">MVNRepository</a>
 */
public class MvnRepositorySearch extends QueryParamSearch {

    private static final String QUERY_TEMPLATE = "https://mvnrepository.com/search?q=%s";

    public MvnRepositorySearch(String query) {
        super(query);
    }

    @Override
    protected String getQueryTemplate() {
        return QUERY_TEMPLATE;
    }

}
