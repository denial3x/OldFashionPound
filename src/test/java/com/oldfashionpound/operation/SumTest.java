package com.oldfashionpound.operation;

import com.oldfashionpound.model.Result;
import com.oldfashionpound.model.Amount;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class SumTest {

  @Test
  void normalAmounts() {
    Amount a = new Amount(BigInteger.valueOf(5), BigInteger.valueOf(17), BigInteger.valueOf(8));
    Amount b = new Amount(BigInteger.valueOf(3), BigInteger.valueOf(4), BigInteger.valueOf(10));
    Result eval = new Sum(a, b).eval();

    assertThat(eval, is(notNullValue()));
    assertThat(eval.getAmount(), is(new Amount(BigInteger.valueOf(9), BigInteger.valueOf(2), BigInteger.valueOf(6))));
    assertThat(eval.getRemainder(), is(new Amount(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO)));
  }

  @Test
  void withZeroAmount() {
    Amount a = new Amount(BigInteger.valueOf(0), BigInteger.valueOf(0), BigInteger.valueOf(0));
    Amount b = new Amount(BigInteger.valueOf(3), BigInteger.valueOf(4), BigInteger.valueOf(10));

    Result eval = new Sum(a, b).eval();

    assertThat(eval, is(notNullValue()));
    assertThat(eval.getAmount(), is(b));
    assertThat(eval.getRemainder(), is(new Amount(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO)));
  }
}
