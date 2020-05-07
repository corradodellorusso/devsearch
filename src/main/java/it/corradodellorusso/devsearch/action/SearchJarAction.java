package it.corradodellorusso.devsearch.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.common.FileAction;
import it.corradodellorusso.devsearch.search.MvnRepositorySearch;
import it.corradodellorusso.devsearch.search.Search;
import org.jetbrains.annotations.NotNull;

/**
 * Searches for jar files on <a href="https://mvnrepository.com/" target="_blank">MVNRepository</a>.
 */
public class SearchJarAction extends FileAction {

    private static final String ENTRY_TEXT = "Search on Maven Repository";
    private static final String JAR_EXTENSION = "jar";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String filename = getFileName(event);
        Search search = new MvnRepositorySearch(filename);
        dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean shouldShow = hasFileAttached(event) && JAR_EXTENSION.equalsIgnoreCase(getFileExtension(event));
        event.getPresentation().setEnabledAndVisible(shouldShow);
        event.getPresentation().setText(ENTRY_TEXT);
    }
}