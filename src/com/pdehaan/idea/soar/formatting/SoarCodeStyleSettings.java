package com.pdehaan.idea.soar.formatting;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class SoarCodeStyleSettings extends CustomCodeStyleSettings
{
    public SoarCodeStyleSettings(CodeStyleSettings container)
    {
        super("SoarCodeStyleSettings", container);
    }
}
