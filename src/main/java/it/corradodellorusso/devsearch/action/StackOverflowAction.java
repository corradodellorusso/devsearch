package it.corradodellorusso.devsearch.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.common.EditorAction;
import it.corradodellorusso.devsearch.search.Search;
import it.corradodellorusso.devsearch.search.StackOverflowSearch;
import org.jetbrains.annotations.NotNull;

/**
 * Builds object to search selected text on <a href="https://stackoverflow.com/" target="_blank">StackOverflow</a>.
 */
public class StackOverflowAction extends EditorAction {

    private static final String ENTRY_TEXT = "Search on StackOverflow";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String text = getSelectedText(event);
        Search search = new StackOverflowSearch(text);
        dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean hasSelection = hasSelectedText(event);
        event.getPresentation().setEnabled(hasSelection);
        event.getPresentation().setText(ENTRY_TEXT);
    }
}
