package it.corradodellorusso.devsearch.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class FileAction extends AnAction {

    public boolean hasFile(@NotNull AnActionEvent event) {
        return event.getData(CommonDataKeys.VIRTUAL_FILE) != null;
    }

    @NotNull
    public VirtualFile getFile(@NotNull AnActionEvent event) {
        return event.getRequiredData(CommonDataKeys.VIRTUAL_FILE);
    }

    @NotNull
    public String getFileName(@NotNull AnActionEvent event) {
        return getFile(event).getName();
    }

    public boolean hasFileExtension(@NotNull AnActionEvent event) {
        String name = getFileName(event);
        return name.contains(".");
    }

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
