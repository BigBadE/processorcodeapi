package com.bigbade.processorcodeapi.javac.expressions;

import com.bigbade.processorcodeapi.api.expressions.ILiteralExpression;
import com.bigbade.processorcodeapi.javac.utils.JavacInternals;
import com.sun.tools.javac.tree.JCTree;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LiteralExpression<T> implements ILiteralExpression<T>, IJavacExpression<JCTree.JCLiteral> {
    private final T literal;

    @Override
    public JCTree.JCLiteral getExpression(JavacInternals data) {
        return data.getTreeMaker().Literal(literal);
    }
}
