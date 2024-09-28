package org.example

import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;

class FunctionClass {
    private var lagrange: PolynomialFunctionLagrangeForm? = null

    fun initialize(x : DoubleArray, y : DoubleArray) {
        lagrange = PolynomialFunctionLagrangeForm(x, y)
    }

    fun evaluate(t : Double) : Double? {
        var value = lagrange?.value(t)
        return value
    }
}