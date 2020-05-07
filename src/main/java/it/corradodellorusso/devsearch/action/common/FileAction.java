package it.corradodellorusso.devsearch.action.common;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
     */
    @NotNull
    public VirtualFile getFile(@NotNull AnActionEvent event) {
        return event.getRequiredData(CommonDataKeys.VIRTUAL_FILE);
    }

    /**
     * Gets the file name of the file attached to the event.
     *
     * @return file name of the file attached.
     */
    @NotNull
    public String getFileName(@NotNull AnActionEvent event) {
        return getFile(event).getName();
    }

    /**
     * Check if the file attached to the event has an extension.
     * Having an extension means containing a dot followed by some characters.
     * The latter checks is not implemented in code because file name cannot end with a dot.
     *
     * @return true if it has an extension.
     */
    public boolean hasFileExtension(@NotNull AnActionEvent event) {
        String name = getFileName(event);
        return name.contains(".");
    }

    /**
     * Gets the file extension of the file attached to the event.
     *
     * @return file extension of the file attached or null.
     */
    @Nullable
    public String getFileExtension(@NotNull AnActionEvent event) {
        String name = getFileName(event);
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return null;
        }
        return name.substring(lastIndexOf + 1);
    }


}
