package it.corradodellorusso.devsearch.action.common;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * Base class for actions dealing with files' metadata.
 * A common usage would be with events triggered from files in project pane.
 */
public abstract class FileAction extends DevSearchAction {

    /**
     * Checks if the event has a file attached.
     * This method has always to be called before dealing with methods below.
     *
     * @return true if it has one.
     */
    public boolean hasFileAttached(@NotNull AnActionEvent event) {
        return event.getData(CommonDataKeys.VIRTUAL_FILE) != null;
    }

    /**
     * Gets the file attached to the event.
     *
     * @return the file attached.
     * @see VirtualFile
     */
    @NotNull
    public VirtualFile getFile(@NotNull AnActionEvent event) {
        return event.getRequiredData(CommonDataKeys.VIRTUAL_FILE);
    }

}
