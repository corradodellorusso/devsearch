package it.corradodellorusso.devsearch.search;

public class MvnRepositorySearch extends GenericQueryParamSearch {

    private static final String QUERY_TEMPLATE = "https://mvnrepository.com/search?q=%s";

    public MvnRepositorySearch(String query) {
        super(query);
    }

    @Override
    protected String getQueryTemplate() {
        return QUERY_TEMPLATE;
    }

}
