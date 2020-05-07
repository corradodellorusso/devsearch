package it.corradodellorusso.devsearch.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.common.EditorAction;
import it.corradodellorusso.devsearch.search.DevToSearch;
import it.corradodellorusso.devsearch.search.Search;
import org.jetbrains.annotations.NotNull;

/**
 * Searches selected text on <a href="https://dev.to" target="_blank">DEV</a>.
 */
public class SearchDevToAction extends EditorAction {

    private static final String ENTRY_TEXT = "Search on DEV.to";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String text = getSelectedText(event);
        Search search = new DevToSearch(text);
        dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean hasSelection = hasSelectedText(event);
        event.getPresentation().setEnabled(hasSelection);
        event.getPresentation().setText(ENTRY_TEXT);
    }
}
