package com.pdehaan.idea.soar;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.pdehaan.idea.soar.psi.SoarTypes;
import org.jetbrains.annotations.NotNull;

public class SoarCompletionContributor extends CompletionContributor
{
    public SoarCompletionContributor()
    {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(SoarTypes.ID_TEST)
                        .withLanguage(SoarLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>()
                {
                    @Override
                    protected void addCompletions(
                            @NotNull CompletionParameters completionParameters,
                            ProcessingContext processingContext,
                            @NotNull CompletionResultSet completionResultSet)
                    {
                        completionResultSet.addElement(
                                LookupElementBuilder.create("<s>"));
                    }
                });
    }
}
