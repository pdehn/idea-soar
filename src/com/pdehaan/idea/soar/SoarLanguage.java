package com.pdehaan.idea.soar;

import com.intellij.lang.Language;

public class SoarLanguage extends Language
{
    public static final SoarLanguage INSTANCE = new SoarLanguage();

    private SoarLanguage()
    {
        super("Soar");
    }
}
