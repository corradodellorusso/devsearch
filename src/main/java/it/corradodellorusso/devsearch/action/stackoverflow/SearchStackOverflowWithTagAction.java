package it.corradodellorusso.devsearch.action.stackoverflow;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.EditorAction;
import it.corradodellorusso.devsearch.dispatcher.Dispatcher;
import it.corradodellorusso.devsearch.search.Search;
import it.corradodellorusso.devsearch.search.StackOverflowSearch;
import org.jetbrains.annotations.NotNull;

public class SearchStackOverflowWithTagAction extends EditorAction {

    private static final String ENTRY_TEXT = "Search on StackOverflow with tag %s";

    private final Dispatcher dispatcher;

    public SearchStackOverflowWithTagAction() {
        super();
        this.dispatcher = new Dispatcher();
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String text = getSelectedText(event);
        String language = getCurrentLanguage(event);
        Search search = new StackOverflowSearch(text, language);
        dispatcher.dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean hasLanguage = hasCurrentLanguage(event);
        boolean hasSelection = hasSelectedText(event);
        if (hasLanguage && hasSelection) {
            String lang = getCurrentLanguage(event);
            event.getPresentation().setText(String.format(ENTRY_TEXT, lang.toLowerCase()));
            event.getPresentation().setEnabledAndVisible(true);
        } else {
            event.getPresentation().setText("");
            event.getPresentation().setEnabledAndVisible(false);
        }
    }
}
