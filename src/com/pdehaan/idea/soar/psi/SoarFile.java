package com.pdehaan.idea.soar.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.pdehaan.idea.soar.SoarFileType;
import com.pdehaan.idea.soar.SoarLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class SoarFile extends PsiFileBase
{
    public SoarFile(@NotNull FileViewProvider fileViewProvider)
    {
        super(fileViewProvider, SoarLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType()
    {
        return SoarFileType.INSTANCE;
    }

    @Override
    public String toString()
    {
        return "Soar File";
    }

    @Override
    public Icon getIcon(int flags)
    {
        return super.getIcon(flags);
    }
}
