package com.bigbade.minecraftplugindevelopment.api.code.parameter;

import com.bigbade.minecraftplugindevelopment.api.code.IClassType;

import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

public interface IParameterType {
    /**
     * Checks if the type is an exact match.
     * For generics this means that the type is the same generic (same letters).
     * For basic parameters this means the type is the same class.
     * @param other Parameter to compare against
     * @return If the above criteria is met
     */
    boolean typeMatches(IParameterType other);

    /**
     * Checks if the type is the element.
     * @param other Type to compare against
     * @return If the above criteria is met
     */
    boolean typeMatches(TypeMirror other);

    /**
     * Checks if the type is the element.
     * @param other Element to compare against
     * @return If the above criteria is met
     */
    boolean typeMatches(Element other);

    /**
     * Gets the simple name of the parameter
     * @return The simple name of the parameter
     */
    String getSimpleName();

    /**
     * Returns the class type of the parameter
     * @return Class type of param
     */
    IClassType getType();
}