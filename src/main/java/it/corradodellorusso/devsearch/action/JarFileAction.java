package it.corradodellorusso.devsearch.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.common.FileAction;
import it.corradodellorusso.devsearch.search.MvnRepositorySearch;
import it.corradodellorusso.devsearch.search.Search;
import org.jetbrains.annotations.NotNull;

/**
 * Builds object to search jar files on <a href="https://mvnrepository.com/" target="_blank">MVNRepository</a>.
 */
public class JarFileAction extends FileAction {

    private static final String ENTRY_TEXT = "Search on Maven Repository";
    private static final String JAR_EXTENSION = "jar";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String filename = getFile(event).getName();
        Search search = new MvnRepositorySearch(filename);
        dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean shouldShow = hasFileAttached(event) && JAR_EXTENSION.equalsIgnoreCase(getFile(event).getExtension());
        event.getPresentation().setEnabledAndVisible(shouldShow);
        event.getPresentation().setText(ENTRY_TEXT);
    }
}
