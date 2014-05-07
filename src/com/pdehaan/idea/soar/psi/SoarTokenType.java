package com.pdehaan.idea.soar.psi;

import com.intellij.psi.tree.IElementType;
import com.pdehaan.idea.soar.SoarLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SoarTokenType extends IElementType
{
    public SoarTokenType(@NotNull @NonNls String debugName)
    {
        super(debugName, SoarLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SoarTokenType." + super.toString();
    }
}
