package com.pdehaan.idea.soar.formatting;

import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import com.pdehaan.idea.soar.SoarLanguage;
import org.jetbrains.annotations.NotNull;

public class SoarLanguageCodeStyleSettingsProvider
    extends LanguageCodeStyleSettingsProvider
{
    @NotNull
    @Override
    public Language getLanguage()
    {
        return SoarLanguage.INSTANCE;
    }

    @Override
    public void customizeSettings(
            @NotNull CodeStyleSettingsCustomizable consumer,
            @NotNull SettingsType settingsType)
    {
        // TODO
    }

    @Override
    public String getCodeSample(@NotNull SettingsType settingsType)
    {
        return "" +
                "sp {production*name\n" +
                "   \"documentation string\"\n" +
                "   (state <s> ^io.output-link <ol>)\n" +
                "-->\n" +
                "   (<ol> ^command <cmd>)\n" +
                "   (<cmd> ^param1 42\n" +
                "   ^param2 |don't panic|)\n" +
                "}";
    }
}
