package oldfashionpound.model;

import java.math.BigInteger;
import java.util.Objects;

public class Amount {

  private static final BigInteger SHILLING_IN_PENNY = BigInteger.valueOf(12);

  private static final BigInteger POUND_IN_SHILLING = BigInteger.valueOf(20);

  private static final BigInteger POUND_IN_PENNY = SHILLING_IN_PENNY.multiply(POUND_IN_SHILLING);

  private BigInteger pounds;

  private BigInteger shillings;

  private BigInteger pennies;

  public Amount(BigInteger pounds, BigInteger shillings, BigInteger pennies) {
    this.pounds = pounds;
    this.shillings = shillings;
    this.pennies = pennies;
  }

  public BigInteger getPounds() {
    return pounds;
  }

  public void setPounds(BigInteger pounds) {
    this.pounds = pounds;
  }

  public BigInteger getShillings() {
    return shillings;
  }

  public void setShillings(BigInteger shillings) {
    this.shillings = shillings;
  }

  public BigInteger getPennies() {
    return pennies;
  }

  public void setPennies(BigInteger pennies) {
    this.pennies = pennies;
  }

  public boolean isEmpty() {
    return pounds.equals(BigInteger.ZERO) && shillings.equals(BigInteger.ZERO) && pennies.equals(BigInteger.ZERO);
  }

  public BigInteger toPennies() {
    return this.pounds.multiply(POUND_IN_PENNY).add(this.shillings.multiply(SHILLING_IN_PENNY)).add(this.pennies);
  }

  public void round() {
    BigInteger d = this.pennies.remainder(SHILLING_IN_PENNY);
    BigInteger s = this.shillings.add(this.pennies.divide(SHILLING_IN_PENNY));
    BigInteger p = this.pounds.add(s.divide(POUND_IN_SHILLING));
    this.setPennies(d);
    this.setShillings(s.remainder(POUND_IN_SHILLING));
    this.setPounds(p);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Amount))
      return false;
    Amount amount = (Amount) o;
    return getPounds().equals(amount.getPounds()) && getShillings().equals(amount.getShillings()) && getPennies()
        .equals(amount.getPennies());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPounds(), getShillings(), getPennies());
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    if (!this.pounds.equals(BigInteger.ZERO))
      stringBuilder.append(this.pounds).append("p ");
    if (!this.shillings.equals(BigInteger.ZERO))
      stringBuilder.append(this.shillings).append("s ");
    if (!this.pennies.equals(BigInteger.ZERO))
      stringBuilder.append(this.pennies).append("d");

    return stringBuilder.toString().trim();
  }

}
