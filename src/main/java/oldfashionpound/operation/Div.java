package oldfashionpound.operation;

import oldfashionpound.Operation;
import oldfashionpound.model.Amount;
import oldfashionpound.model.Result;

import java.math.BigInteger;

public class Div implements Operation {
    private final Amount a;
    private final BigInteger divisor;

    public Div(Amount a, BigInteger bigInteger) {
        this.a = a;
        this.divisor = bigInteger;
    }

    @Override
    public Result eval() {
        if (divisor.compareTo(BigInteger.ZERO) > 0) {
            BigInteger pennies = a.toPennies().divide(divisor);
            BigInteger remainderInPennies = pennies.remainder(divisor);
            Amount amount = new Amount(BigInteger.ZERO, BigInteger.ZERO, pennies);
            Amount remainder = new Amount(BigInteger.ZERO, BigInteger.ZERO, remainderInPennies);
            amount.round();
            remainder.round();
            return new Result(amount, remainder);
        } else
            throw new ArithmeticException("Invalid divisor.");
    }
}
