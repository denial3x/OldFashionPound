package oldfashionpound.operation;

import oldfashionpound.Operation;
import oldfashionpound.model.Amount;
import oldfashionpound.model.Result;

import java.math.BigInteger;

public class Diff implements Operation {
    private final Amount a;
    private final Amount b;

    public Diff(Amount a, Amount b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Result eval() {
        BigInteger pennies = a.toPennies().subtract(b.toPennies());
        Amount result = new Amount(BigInteger.ZERO, BigInteger.ZERO, pennies);
        result.round();
        return new Result(result);
    }
}
