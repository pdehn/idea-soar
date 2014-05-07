package com.pdehaan.idea.soar.formatting;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.pdehaan.idea.soar.psi.SoarStateImpCond;
import com.pdehaan.idea.soar.psi.SoarTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SoarBlock extends AbstractBlock
{
    protected final CodeStyleSettings settings;

    protected SoarBlock(
            @NotNull ASTNode astNode,
            @Nullable Wrap wrap,
            @Nullable Alignment alignment,
            CodeStyleSettings settings)
    {
        super(astNode, wrap, alignment);
        this.settings = settings;
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2)
    {
        return new SpacingBuilder(settings)
                .getSpacing(this, child1, child2);
//        return new SpacingBuilder(settings).getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf()
    {
        return myNode.getFirstChildNode() == null;
    }

    @Override
    public Indent getIndent()
    {
        if (myNode.getElementType() instanceof SoarStateImpCond)
        {
            return Indent.getSpaceIndent(4, true);
        }
        else if (myNode.getElementType() == SoarTypes.RARROW)
        {
            return Indent.getSpaceIndent(-4);
        }

        return Indent.getNoneIndent();
    }

    @Override
    protected List<Block> buildChildren()
    {
        List<Block> subBlocks = new ArrayList<Block>();

        Alignment attrValueAlign = null;

        for (ASTNode child : myNode.getChildren(null))
        {
            if (child.getText().trim().equals("")) continue;

            Alignment alignment = Alignment.createAlignment();

            if (child.getElementType() == SoarTypes.ATTR_VALUE_TESTS ||
                    child.getElementType() == SoarTypes.ATTR_VALUE_MAKE)
            {
                if (attrValueAlign == null)
                {
                    attrValueAlign = Alignment.createAlignment();
                }
                alignment = attrValueAlign;
            }

            subBlocks.add(new SoarBlock(
                    child,
                    Wrap.createWrap(WrapType.NONE, false),
                    alignment,
                    settings));
        }
        return subBlocks;
    }
}
