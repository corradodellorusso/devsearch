package it.corradodellorusso.devsearch.action;

import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public abstract class EditorAction extends AnAction {

    private static final Language PLAIN_TEXT_LANGUAGE = Language.findInstance(PlainTextLanguage.class);

    public String getSelectedText(@NotNull AnActionEvent event) {
        Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        return caretModel.getCurrentCaret().getSelectedText();
    }

    public boolean hasSelectedText(@NotNull AnActionEvent event) {
        Editor editor = event.getData(CommonDataKeys.EDITOR);
        if (editor == null) {
            return false;
        }
        CaretModel caretModel = editor.getCaretModel();
        return caretModel.getCurrentCaret().hasSelection();
    }

    public String getCurrentLanguage(@NotNull AnActionEvent event) {
        Language lang = event.getData(CommonDataKeys.PSI_FILE).getLanguage();
        return lang.getDisplayName();
    }

    public boolean hasCurrentLanguage(@NotNull AnActionEvent event) {
        PsiFile file = event.getData(CommonDataKeys.PSI_FILE);
        if (file == null) {
            return false;
        }
        Language lang = file.getLanguage();
        return lang != PLAIN_TEXT_LANGUAGE;
    }


}
