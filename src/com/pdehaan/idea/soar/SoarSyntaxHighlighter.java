package com.pdehaan.idea.soar;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.pdehaan.idea.soar.psi.SoarTypes;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SoarSyntaxHighlighter extends SyntaxHighlighterBase
{
    public static final TextAttributesKey SYMBOL = createTextAttributesKey(
            "SOAR_SYMBOL", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey NUMBER = createTextAttributesKey(
            "SOAR_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey VARIABLE = createTextAttributesKey(
            "SOAR_VARIABLE", DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);

    public static final TextAttributesKey OPERATOR = createTextAttributesKey(
            "SOAR_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);

    public static final TextAttributesKey DOCSTRING = createTextAttributesKey(
            "SOAR_DOCSTRING", DefaultLanguageHighlighterColors.DOC_COMMENT);

    private static final TextAttributesKey[] EMPTY_KEYS =
            new TextAttributesKey[0];
    private static final TextAttributesKey[] SYMBOL_KEYS =
            new TextAttributesKey[]{SYMBOL};
    private static final TextAttributesKey[] NUMBER_KEYS =
            new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] VARIABLE_KEYS =
            new TextAttributesKey[]{VARIABLE};
    private static final TextAttributesKey[] OPERATOR_KEYS =
            new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] DOCSTRING_KEYS =
            new TextAttributesKey[]{DOCSTRING};


    @NotNull
    @Override
    public Lexer getHighlightingLexer()
    {
        return new FlexAdapter(new _SoarLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType)
    {
        if (SoarTypes.STRING.equals(tokenType))
        {
            return DOCSTRING_KEYS;
        }
        if (SoarTypes.SYM_CONSTANT.equals(tokenType))
        {
            return SYMBOL_KEYS;
        }
        else if (SoarTypes.FLOAT_CONSTANT.equals(tokenType) ||
                SoarTypes.INT_CONSTANT.equals(tokenType))
        {
            return NUMBER_KEYS;
        }
        else if (SoarTypes.VARIABLE.equals(tokenType))
        {
            return VARIABLE_KEYS;
        }
        else if (SoarTypes.RARROW.equals(tokenType))
        {
            return OPERATOR_KEYS;
        }
        return EMPTY_KEYS;
    }
}
