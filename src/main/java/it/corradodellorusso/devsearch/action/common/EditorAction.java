package it.corradodellorusso.devsearch.action.common;

import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * Base class for actions dealing with editor and console.
 */
public abstract class EditorAction extends DevSearchAction {

    private static final Language PLAIN_TEXT_LANGUAGE = Language.findInstance(PlainTextLanguage.class);

    /**
     * Checks if we have any text selected.
     *
     * @return true if has selection.
     */
    public boolean hasSelectedText(@NotNull AnActionEvent event) {
        Editor editor = event.getData(CommonDataKeys.EDITOR);
        if (editor == null) {
            return false;
        }
        CaretModel caretModel = editor.getCaretModel();
        return caretModel.getCurrentCaret().hasSelection();
    }

    /**
     * Gets the selected text.
     *
     * @return selected text.
     */
    public String getSelectedText(@NotNull AnActionEvent event) {
        Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        return caretModel.getCurrentCaret().getSelectedText();
    }

    /**
     * Checks if a language is detected for current file.
     * This will be working only for editor.
     * We not consider plain text as a language.
     *
     * @return true if a language is detected.
     */
    public boolean hasCurrentLanguage(@NotNull AnActionEvent event) {
        PsiFile file = event.getData(CommonDataKeys.PSI_FILE);
        if (file == null) {
            return false;
        }
        Language lang = file.getLanguage();
        return lang != PLAIN_TEXT_LANGUAGE;
    }

    /**
     * Gets the current language.
     * Always call after {@link #hasCurrentLanguage(AnActionEvent)}.
     *
     * @return the language.
     */
    public String getCurrentLanguage(@NotNull AnActionEvent event) {
        Language lang = event.getData(CommonDataKeys.PSI_FILE).getLanguage();
        return lang.getDisplayName();
    }

}
