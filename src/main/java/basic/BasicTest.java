package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  /* if i or n is too big or negative return Option None */
  public static Option<Integer> power(Integer i, Integer n) {
    if(i >= 0 && n >= 0 && i < 100 && n < 100){
      return Option.of((int) Math.pow(i,n));
    }
    return Option.none();
  }

  public static void main(String[] args) {
    System.out.println(power(7,3));
    System.out.println(power(-1,3));
    System.out.println(power(7,-1));
  }
}
