package com.oldfashionpound.operation;

import com.oldfashionpound.model.Result;
import com.oldfashionpound.model.Amount;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class MulTest {

  @Test
  void withNormalAmountAndMultiplier() {
    Amount a = new Amount(BigInteger.valueOf(5), BigInteger.valueOf(17), BigInteger.valueOf(8));
    BigInteger multiplier = BigInteger.valueOf(2);
    Result eval = new Mul(a, multiplier).eval();

    assertThat(eval, is(notNullValue()));
    assertThat(eval.getAmount(), is(new Amount(BigInteger.valueOf(11), BigInteger.valueOf(15), BigInteger.valueOf(4))));
    assertThat(eval.getRemainder(), is(new Amount(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO)));
  }

  @Test
  void withZeroMultiplier() {
    Amount a = new Amount(BigInteger.valueOf(5), BigInteger.valueOf(17), BigInteger.valueOf(8));
    BigInteger multiplier = BigInteger.valueOf(0);
    Result eval = new Mul(a, multiplier).eval();

    assertThat(eval, is(notNullValue()));
    assertThat(eval.getAmount(), is(new Amount(BigInteger.valueOf(0), BigInteger.valueOf(0), BigInteger.valueOf(0))));
    assertThat(eval.getRemainder(), is(new Amount(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO)));
  }

  @Test
  void withNegativeMultiplier() {
    Amount a = new Amount(BigInteger.valueOf(5), BigInteger.valueOf(17), BigInteger.valueOf(8));
    BigInteger multiplier = BigInteger.valueOf(-2);
    Result eval = new Mul(a, multiplier).eval();

    assertThat(eval, is(notNullValue()));
    assertThat(eval.getAmount(), is(new Amount(BigInteger.valueOf(11).negate(), BigInteger.valueOf(15).negate(), BigInteger.valueOf(4).negate())));
    assertThat(eval.getRemainder(), is(new Amount(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO)));
  }
}
