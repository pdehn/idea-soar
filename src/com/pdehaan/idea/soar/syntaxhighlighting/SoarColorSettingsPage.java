package com.pdehaan.idea.soar.syntaxhighlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.pdehaan.idea.soar.SoarIcons;
import com.pdehaan.idea.soar.syntaxhighlighting.SoarSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class SoarColorSettingsPage implements ColorSettingsPage
{
    private static final AttributesDescriptor[] DESCRIPTORS =
            new AttributesDescriptor[]{
                    new AttributesDescriptor("Documentation", SoarSyntaxHighlighter.DOCSTRING),
                    new AttributesDescriptor("Symbol", SoarSyntaxHighlighter.SYMBOL),
                    new AttributesDescriptor("Number", SoarSyntaxHighlighter.NUMBER),
                    new AttributesDescriptor("Variable", SoarSyntaxHighlighter.VARIABLE),
                    new AttributesDescriptor("Operator", SoarSyntaxHighlighter.OPERATOR)
            };

    @Nullable
    @Override
    public Icon getIcon()
    {
        return SoarIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter()
    {
        return new SoarSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText()
    {
        return "" +
                "sp {production*name\n" +
                "   \"documentation string\"\n" +
                "   (state <s> ^io.output-link <ol>)\n" +
                "-->\n" +
                "   (<ol> ^command <cmd>)\n" +
                "   (<cmd> ^param 42)\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap()
    {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors()
    {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors()
    {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName()
    {
        return "Soar";
    }
}
