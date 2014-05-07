package com.pdehaan.idea.soar;

import com.intellij.lexer.FlexAdapter;

public class SoarLexer extends FlexAdapter
{
    public SoarLexer()
    {
        super(new _SoarLexer());
    }
}
