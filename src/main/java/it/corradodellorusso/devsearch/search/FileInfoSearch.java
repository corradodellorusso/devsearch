package it.corradodellorusso.devsearch.search;

public class FileInfoSearch implements Search {

    private static final String QUERY_TEMPLATE = "https://fileinfo.com/extension/%s";

    private final String extension;

    public FileInfoSearch(String extension) {
        this.extension = extension;
    }

    @Override
    public String toUrl() {
        return String.format(QUERY_TEMPLATE, extension);
    }

    public String getExtension() {
        return extension;
    }

}
