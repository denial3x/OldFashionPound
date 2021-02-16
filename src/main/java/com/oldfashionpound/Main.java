package com.oldfashionpound;

import static java.lang.System.out;

public class Main {
  public static void main(String[] args) {
    out.println(Resolver.resolve(String.join(" ", args)));
  }
}
