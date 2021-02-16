package oldfashionpound.model;

import java.math.BigInteger;

public class Result {
    Amount amount;
    Amount remainder;

    public Result(Amount amount) {
        this.amount = amount;
        this.remainder = new Amount(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO);
    }

    public Result(Amount amount, Amount remainder) {
        this.amount = amount;
        this.remainder = remainder;
    }

  public Amount getAmount() {
    return amount;
  }

  public void setAmount(Amount amount) {
    this.amount = amount;
  }

  public Amount getRemainder() {
    return remainder;
  }

  public void setRemainder(Amount remainder) {
    this.remainder = remainder;
  }

  @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(amount.toString());
        if (!remainder.isEmpty()) {
            stringBuilder.append(" ( ");
            stringBuilder.append(this.remainder.toString());
            stringBuilder.append(" )");
        }

        return stringBuilder.toString();
    }
}
