package com.bigbade.processorcodeapi.javac.code.parameter;

import com.bigbade.processorcodeapi.api.code.IClassType;
import com.bigbade.processorcodeapi.api.code.parameter.IParameterType;
import com.bigbade.processorcodeapi.javac.code.JavacVersion;
import com.bigbade.processorcodeapi.javac.utils.JavacInternals;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nullable;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

@Getter
@RequiredArgsConstructor
public class JavacParameterType implements JavacVersion<JCTree.JCIdent>, IParameterType {
    @Nullable
    private final IClassType type;

    @Override
    public JCTree.JCIdent getExpression(JavacInternals internals) {
        return type == null ?
                null : internals.getTreeMaker().Ident(internals.getNames().fromString(type.getQualifiedName()));
    }

    @Override
    public boolean typeMatches(IParameterType other) {
        return type == null ? other.getType() == null :
                other.getType().getQualifiedName().equals(type.getQualifiedName());
    }

    @Override
    public boolean typeMatches(TypeMirror other) {
        return type == null ? other instanceof Type.JCNoType :
                ((Type) other).tsym.getQualifiedName().contentEquals(type.getQualifiedName());
    }

    @Override
    public boolean typeMatches(Element other) {
        return type == null ? other.getSimpleName().contentEquals("void") :
                ((Symbol.ClassSymbol) other).fullname.contentEquals(type.getQualifiedName());
    }

    @Override
    public String getSimpleName() {
        return type == null ? "void" : type.getSimpleName();
    }
}
