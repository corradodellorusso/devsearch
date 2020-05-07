package it.corradodellorusso.devsearch.search;

import java.net.URI;

/**
 * Builds search for <a href="https://fileinfo.com/" target="_blank">FileInfo</a>.
 */
public class FileInfoSearch implements Search {

    private static final String QUERY_TEMPLATE = "https://fileinfo.com/extension/%s";

    private final String extension;

    public FileInfoSearch(String extension) {
        this.extension = extension;
    }

    @Override
    public URI toURI() {
        return URI.create(String.format(QUERY_TEMPLATE, extension));
    }

    public String getExtension() {
        return extension;
    }

}
