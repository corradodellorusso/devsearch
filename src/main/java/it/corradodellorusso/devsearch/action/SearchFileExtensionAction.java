package it.corradodellorusso.devsearch.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.common.FileAction;
import it.corradodellorusso.devsearch.search.FileInfoSearch;
import it.corradodellorusso.devsearch.search.Search;
import org.jetbrains.annotations.NotNull;

/**
 * Searches for file extension on <a href="https://fileinfo.com/" target="_blank">FileInfo</a>.
 */
public class SearchFileExtensionAction extends FileAction {

    private static final String ENTRY_TEXT = "Search %s on FileInfo";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String extension = getFileExtension(event);
        Search search = new FileInfoSearch(extension);
        dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean shouldShow = hasFileAttached(event) && hasFileExtension(event);
        event.getPresentation().setEnabledAndVisible(shouldShow);
        if (!shouldShow) {
            return;
        }
        event.getPresentation().setText(String.format(ENTRY_TEXT, getFileExtension(event)));
    }

}
