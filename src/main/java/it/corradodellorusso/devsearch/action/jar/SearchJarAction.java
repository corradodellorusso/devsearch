package it.corradodellorusso.devsearch.action.jar;

import com.intellij.openapi.actionSystem.AnActionEvent;
import it.corradodellorusso.devsearch.action.FileAction;
import it.corradodellorusso.devsearch.dispatcher.Dispatcher;
import it.corradodellorusso.devsearch.search.MvnRepositorySearch;
import it.corradodellorusso.devsearch.search.Search;
import org.jetbrains.annotations.NotNull;

public class SearchJarAction extends FileAction {

    private static final String ENTRY_TEXT = "Search on Maven Repository";
    private static final String JAR_EXTENSION = "jar";

    private final Dispatcher dispatcher;

    public SearchJarAction() {
        super();
        this.dispatcher = new Dispatcher();
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String filename = getFileName(event);
        Search search = new MvnRepositorySearch(filename);
        dispatcher.dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean shouldShow = hasFile(event) && JAR_EXTENSION.equalsIgnoreCase(getFileExtension(event));
        event.getPresentation().setEnabledAndVisible(shouldShow);
        event.getPresentation().setText(ENTRY_TEXT);
    }
}
