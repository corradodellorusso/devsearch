package it.corradodellorusso.devsearch.search;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class StackOverflowSearch implements Search {

    private static final String QUERY_TEMPLATE = "https://stackoverflow.com/search?q=%s";

    private final String query;
    private final String tag;

    public StackOverflowSearch(String query) {
        this.query = query;
        this.tag = null;
    }

    public StackOverflowSearch(String query, String tag) {
        this.query = query;
        this.tag = tag;
    }

    @Override
    public String toUrl() {
        StringBuilder builder = new StringBuilder();
        if (tag != null) {
            builder.append("[");
            builder.append(tag.toLowerCase());
            builder.append("]");
            builder.append(" ");
        }
        builder.append(query);
        String string = builder.toString();
        String encoded = URLEncoder.encode(string, StandardCharsets.UTF_8);
        return String.format(QUERY_TEMPLATE, encoded);
    }

    public String getQuery() {
        return query;
    }

    public String getTag() {
        return tag;
    }
}
