package com.pdehaan.idea.soar.formatting;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.openapi.options.Configurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import com.pdehaan.idea.soar.SoarLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SoarCodeStyleSettingsProvider extends CodeStyleSettingsProvider
{
    @Override
    public CustomCodeStyleSettings createCustomSettings(
            CodeStyleSettings settings)
    {
        return new SoarCodeStyleSettings(settings);
    }

    @Nullable
    @Override
    public String getConfigurableDisplayName()
    {
        return "Soar";
    }

    @NotNull
    @Override
    public Configurable createSettingsPage(
            CodeStyleSettings settings,
            final CodeStyleSettings originalSettings)
    {
        return new CodeStyleAbstractConfigurable(
                settings,
                originalSettings,
                "Soar")
        {
            @Override
            protected CodeStyleAbstractPanel createPanel(
                    CodeStyleSettings settings)
            {
                return new SoarCodeStyleMainPanel(
                        getCurrentSettings(),
                        settings);
            }

            @Nullable
            @Override
            public String getHelpTopic()
            {
                return null;
            }
        };
    }

    private static class SoarCodeStyleMainPanel
            extends TabbedLanguageCodeStylePanel
    {

        protected SoarCodeStyleMainPanel(
                CodeStyleSettings currentSettings,
                CodeStyleSettings settings)
        {
            super(SoarLanguage.INSTANCE, currentSettings, settings);
        }
    }
}
