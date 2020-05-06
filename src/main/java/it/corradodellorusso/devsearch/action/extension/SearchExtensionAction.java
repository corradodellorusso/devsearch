package it.corradodellorusso.devsearch.action.extension;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.FileAction;
import it.corradodellorusso.devsearch.dispatcher.Dispatcher;
import it.corradodellorusso.devsearch.search.FileInfoSearch;
import it.corradodellorusso.devsearch.search.Search;
import org.jetbrains.annotations.NotNull;

public class SearchExtensionAction extends FileAction {

    private static final String ENTRY_TEXT = "Search %s on File Info";

    private final Dispatcher dispatcher;

    public SearchExtensionAction() {
        super();
        this.dispatcher = new Dispatcher();
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String extension = getFileExtension(event);
        Search search = new FileInfoSearch(extension);
        dispatcher.dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean shouldShow = hasFile(event) && hasFileExtension(event);
        event.getPresentation().setEnabledAndVisible(shouldShow);
        if (!shouldShow) {
            return;
        }
        event.getPresentation().setText(String.format(ENTRY_TEXT, getFileExtension(event)));
    }

    @Override
    public boolean isDumbAware() {
        return true;
    }
}
