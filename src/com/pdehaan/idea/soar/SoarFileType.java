package com.pdehaan.idea.soar;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SoarFileType extends LanguageFileType
{
    public static final SoarFileType INSTANCE = new SoarFileType();

    private SoarFileType()
    {
        super(SoarLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName()
    {
        return "Soar file";
    }

    @NotNull
    @Override
    public String getDescription()
    {
        return "Soar file";
    }

    @NotNull
    @Override
    public String getDefaultExtension()
    {
        return "soar";
    }

    @Nullable
    @Override
    public Icon getIcon()
    {
        return SoarIcons.FILE;
    }
}
