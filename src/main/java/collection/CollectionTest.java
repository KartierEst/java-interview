package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    Objects.requireNonNull(input);
    return input.stream().map(x ->(Math.pow(((x * 2) + 3),5))).toList();
  }

  /**
   * operation : abc -> AbcAbc
   */

  /* if the word is null or empty, you return the same */
  public static List<String> compute2(List<String> input) {
    Objects.requireNonNull(input);
    return input.stream()
            .map(x -> {
              if(x == null || x.equals("")){
                return x;
              }
              var first = x.toUpperCase().charAt(0);
              var rest = x.substring(1);
              return first + rest + first + rest;
            })
            .toList();
  }

  public static void main(String[] args) {
    var list = new ArrayList<String>();
    var list2 = new ArrayList<Integer>();
    list2.add(6);
    list2.add(0);
    list2.add(2);
    list.add("abc");
    System.out.print(compute2(list));
    System.out.println(compute1(list2));
  }

}
