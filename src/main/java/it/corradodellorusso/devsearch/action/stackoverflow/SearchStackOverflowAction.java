package it.corradodellorusso.devsearch.action.stackoverflow;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.EditorAction;
import it.corradodellorusso.devsearch.dispatcher.Dispatcher;
import it.corradodellorusso.devsearch.search.Search;
import it.corradodellorusso.devsearch.search.StackOverflowSearch;
import org.jetbrains.annotations.NotNull;

public class SearchStackOverflowAction extends EditorAction {

    private static final String ENTRY_TEXT = "Search on StackOverflow";

    private final Dispatcher dispatcher;

    public SearchStackOverflowAction() {
        super();
        this.dispatcher = new Dispatcher();
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String text = getSelectedText(event);
        Search search = new StackOverflowSearch(text);
        dispatcher.dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean hasSelection = hasSelectedText(event);
        event.getPresentation().setEnabled(hasSelection);
        event.getPresentation().setText(ENTRY_TEXT);
    }
}
