package it.corradodellorusso.devsearch.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.common.EditorAction;
import it.corradodellorusso.devsearch.search.Search;
import it.corradodellorusso.devsearch.search.StackOverflowSearch;
import org.jetbrains.annotations.NotNull;

/**
 * Searches selected text on <a href="https://stackoverflow.com/" target="_blank">StackOverflow</a> using the language as tag.
 */
public class SearchStackOverflowWithTagAction extends EditorAction {

    private static final String ENTRY_TEXT = "Search on StackOverflow with tag %s";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String text = getSelectedText(event);
        String language = getCurrentLanguage(event);
        Search search = new StackOverflowSearch(text, language);
        dispatch(search);
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
