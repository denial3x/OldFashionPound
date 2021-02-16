package com.oldfashionpound.operation;

import com.oldfashionpound.model.Amount;
import com.oldfashionpound.model.Result;

import java.math.BigInteger;

public class Mul implements Operation {
    private final Amount a;
    private final BigInteger multiplier;

    public Mul(Amount a, BigInteger multiplier) {
        this.a = a;
        this.multiplier = multiplier;
    }

    @Override
    public Result eval() {
        BigInteger pennies = a.toPennies().multiply(multiplier);
        Amount result = new Amount(BigInteger.ZERO, BigInteger.ZERO, pennies);
        result.round();

        return new Result(result);
    }
}
