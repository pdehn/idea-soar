package com.pdehaan.idea.soar.psi;

import com.intellij.psi.tree.IElementType;
import com.pdehaan.idea.soar.SoarLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SoarElementType extends IElementType
{
    public SoarElementType(@NotNull @NonNls String debugName)
    {
        super(debugName, SoarLanguage.INSTANCE);
    }
}
