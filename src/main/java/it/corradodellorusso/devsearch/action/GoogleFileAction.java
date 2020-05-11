package it.corradodellorusso.devsearch.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.common.FileAction;
import it.corradodellorusso.devsearch.search.GoogleFileSearch;
import it.corradodellorusso.devsearch.search.Search;
import org.jetbrains.annotations.NotNull;

/**
 * Builds object to search jar files on <a href="https://google.com/" target="_blank">Google</a>.
 */
public class GoogleFileAction extends FileAction {

    private static final String ENTRY_TEXT = "Search on Google";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String filename = getFile(event).getName();
        Search search = new GoogleFileSearch(filename);
        dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean shouldShow = hasFileAttached(event);
        event.getPresentation().setEnabledAndVisible(shouldShow);
        event.getPresentation().setText(ENTRY_TEXT);
    }
}
