package com.oldfashionpound.operation;

import com.oldfashionpound.model.Amount;
import com.oldfashionpound.model.Result;

import java.math.BigInteger;

public class Sum implements Operation {
    private final Amount a;
    private final Amount b;

    public Sum(Amount a, Amount b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Result eval() {
        BigInteger pennies = a.toPennies().add(b.toPennies());
        Amount amount = new Amount(BigInteger.ZERO, BigInteger.ZERO, pennies);
        amount.round();
        return new Result(amount);
    }
}
