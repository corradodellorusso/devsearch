package it.corradodellorusso.devsearch.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.vfs.VirtualFile;
import it.corradodellorusso.devsearch.action.common.FileAction;
import it.corradodellorusso.devsearch.search.NpmSearch;
import it.corradodellorusso.devsearch.search.Search;
import org.jetbrains.annotations.NotNull;

/**
 * Builds object to search jar files on <a href="https://www.npmjs.com/" target="_blank">NPM</a>.
 */
public class NpmAction extends FileAction {

    private static final String NODE_MODULES_FOLDER = "node_modules";
    private static final String ENTRY_TEXT = "Search %s on NPM";

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        String name = getFile(e).getName();
        Search search = new NpmSearch(name);
        dispatch(search);
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        // No file, no action
        if (!hasFileAttached(e)) {
            hide(e);
            return;
        }

        VirtualFile file = getFile(e);

        // Not a folder or root folder.
        if (!file.isDirectory() || file.getParent() == null) {
            hide(e);
            return;
        }

        VirtualFile parent = file.getParent();

        // It's a node library!
        if (NODE_MODULES_FOLDER.equals(parent.getName())) {
            show(e, String.format(ENTRY_TEXT, file.getName()));
        }

    }

    private void hide(@NotNull AnActionEvent e) {
        e.getPresentation().setEnabledAndVisible(false);
        e.getPresentation().setText("");
    }

    private void show(@NotNull AnActionEvent e, String text) {
        e.getPresentation().setEnabledAndVisible(true);
        e.getPresentation().setText(text);
    }

}
