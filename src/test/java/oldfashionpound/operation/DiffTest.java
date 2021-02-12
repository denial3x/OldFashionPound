package oldfashionpound.operation;

import oldfashionpound.model.Amount;
import oldfashionpound.model.Result;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class DiffTest {

  @Test
  void withNormalAmounts() {
    Amount a = new Amount(BigInteger.valueOf(5), BigInteger.valueOf(17), BigInteger.valueOf(8));
    Amount b = new Amount(BigInteger.valueOf(3), BigInteger.valueOf(4), BigInteger.valueOf(10));
    Result eval = new Diff(a, b).eval();

    assertThat(eval, is(notNullValue()));
    assertThat(eval.getAmount(), is(new Amount(BigInteger.valueOf(2), BigInteger.valueOf(12), BigInteger.valueOf(10))));
    assertThat(eval.getRemainder(), is(new Amount(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO)));
  }

  @Test
  void withZeroAmounts() {
    Amount a = new Amount(BigInteger.valueOf(5), BigInteger.valueOf(17), BigInteger.valueOf(8));
    Amount b = new Amount(BigInteger.valueOf(0), BigInteger.valueOf(0), BigInteger.valueOf(0));
    Result eval = new Diff(a, b).eval();

    assertThat(eval, is(notNullValue()));
    assertThat(eval.getAmount(), is(a));
    assertThat(eval.getRemainder(), is(new Amount(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO)));
  }

  @Test void negativeResult() {
    Amount a = new Amount(BigInteger.valueOf(5), BigInteger.valueOf(17), BigInteger.valueOf(8));
    Amount b = new Amount(BigInteger.valueOf(7), BigInteger.valueOf(12), BigInteger.valueOf(8));
    Result eval = new Diff(a, b).eval();

    assertThat(eval, is(notNullValue()));
    assertThat(eval.getAmount(), is(new Amount(BigInteger.valueOf(1).negate(), BigInteger.valueOf(15).negate(), BigInteger.ZERO)));
    assertThat(eval.getRemainder(), is(new Amount(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO)));
  }
}
