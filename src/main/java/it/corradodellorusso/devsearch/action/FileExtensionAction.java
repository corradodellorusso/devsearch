package it.corradodellorusso.devsearch.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.common.FileAction;
import it.corradodellorusso.devsearch.search.FileInfoSearch;
import it.corradodellorusso.devsearch.search.Search;
import org.jetbrains.annotations.NotNull;

/**
 * Builds object to search file extension on <a href="https://fileinfo.com/" target="_blank">FileInfo</a>.
 */
public class FileExtensionAction extends FileAction {

    private static final String ENTRY_TEXT = "Search %s on FileInfo";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String extension = getFile(event).getExtension();
        Search search = new FileInfoSearch(extension);
        dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean shouldShow = hasFileAttached(event) && getFile(event).getExtension() != null;
        event.getPresentation().setEnabledAndVisible(shouldShow);
        if (!shouldShow) {
            return;
        }
        event.getPresentation().setText(String.format(ENTRY_TEXT, getFile(event).getExtension()));
    }

}
