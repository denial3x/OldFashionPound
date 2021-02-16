package com.oldfashionpound;

import com.oldfashionpound.model.Result;
import com.oldfashionpound.operation.Div;
import com.oldfashionpound.operation.Sum;
import com.oldfashionpound.model.Amount;
import com.oldfashionpound.operation.Diff;
import com.oldfashionpound.operation.Mul;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Resolver {

  private static final String MAX_TWO_OPERANDS = "Max 2 operands allowed at the moment.";

  private Resolver() {

  }

  //TODO Not a professional parser, really basic and amatorial, fragile. Need to create one more powerful!
  // (maybe that accepts more than 2 params, parenthesis etc...).
  // (Also i personally hate if-elseif-else logic...Not SOLID).
  public static String resolve(String expression) {
    if (expression.contains("+")) {
      List<String> splittedExpression = Arrays.stream(expression.split("\\+")).map(String::trim)
          .collect(Collectors.toList());
      if (splittedExpression.size() > 2)
        throw new UnsupportedOperationException();

      Amount a = parseString(splittedExpression.get(0));
      Amount b = parseString(splittedExpression.get(1));

      Result result = new Sum(a, b).eval();
      return result.toString();
    } else if (expression.contains("-")) {
      List<String> splittedExpression = Arrays.stream(expression.split("-")).map(String::trim)
          .collect(Collectors.toList());
      if (splittedExpression.size() > 2)
        throw new UnsupportedOperationException(MAX_TWO_OPERANDS);

      Amount a = parseString(splittedExpression.get(0));
      Amount b = parseString(splittedExpression.get(1));

      Result result = new Diff(a, b).eval();
      return result.toString();
    } else if (expression.contains("*")) {
      List<String> splittedExpression = Arrays.stream(expression.split("\\*")).map(String::trim)
          .collect(Collectors.toList());
      if (splittedExpression.size() > 2)
        throw new UnsupportedOperationException(MAX_TWO_OPERANDS);

      Amount a = parseString(splittedExpression.get(0));

      Result result = new Mul(a, new BigInteger(splittedExpression.get(1))).eval();
      return result.toString();
    } else if (expression.contains("/")) {
      List<String> splittedExpression = Arrays.stream(expression.split("/")).map(String::trim)
          .collect(Collectors.toList());
      if (splittedExpression.size() > 2)
        throw new UnsupportedOperationException(MAX_TWO_OPERANDS);

      Amount a = parseString(splittedExpression.get(0));

      Result result = new Div(a, new BigInteger(splittedExpression.get(1))).eval();
      return result.toString();
    }
    throw new UnsupportedOperationException("Invalid Operation.");
  }

  private static Amount parseString(String s) {
    Amount amount = new Amount(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO);
    amount.setPennies(getPenniesFromString(s));
    amount.setShillings(getShillingFromString(s));
    amount.setPounds(getPoundsFromString(s));
    return amount;
  }

  private static BigInteger getPoundsFromString(String s) {
    Matcher matcher = Pattern.compile("(\\d+)(?=p)").matcher(s);

    if (matcher.find())
      return new BigInteger(matcher.group(0));

    return BigInteger.ZERO;
  }

  private static BigInteger getShillingFromString(String s) {
    Matcher matcher = Pattern.compile("(\\d+)(?=s)").matcher(s);

    if (matcher.find())
      return new BigInteger(matcher.group(0));

    return BigInteger.ZERO;
  }

  private static BigInteger getPenniesFromString(String s) {
    Matcher matcher = Pattern.compile("(\\d+)(?=d)").matcher(s);

    if (matcher.find())
      return new BigInteger(matcher.group(0));

    return BigInteger.ZERO;
  }
}
