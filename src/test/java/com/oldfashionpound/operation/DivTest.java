package com.oldfashionpound.operation;

import com.oldfashionpound.model.Amount;
import com.oldfashionpound.model.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivTest {

  @Test
  void withNormalAmountAndDivisor() {
    Amount a = new Amount(BigInteger.valueOf(5), BigInteger.valueOf(17), BigInteger.valueOf(8));
    BigInteger divisor = BigInteger.valueOf(3);
    Result eval = new Div(a, divisor).eval();

    assertThat(eval, is(notNullValue()));
    assertThat(eval.getAmount(), is(new Amount(BigInteger.valueOf(1), BigInteger.valueOf(19), BigInteger.valueOf(2))));
    assertThat(eval.getRemainder(), is(new Amount(BigInteger.ZERO, BigInteger.ZERO, BigInteger.valueOf(2))));
  }

  @Test
  void withZeroDivisor() {
    Amount a = new Amount(BigInteger.valueOf(5), BigInteger.valueOf(17), BigInteger.valueOf(8));
    BigInteger divisor = BigInteger.valueOf(0);

    Executable divSupplier = () -> new Div(a, divisor).eval();
    assertThrows(ArithmeticException.class, divSupplier);
  }
}
