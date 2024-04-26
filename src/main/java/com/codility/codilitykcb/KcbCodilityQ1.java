package com.codility.codilitykcb;

import java.util.HashSet;
import java.util.Set;

public class KcbCodilityQ1 {

  public int solution(int[] A) {
    Set<Integer> distinctAbsValues = new HashSet<>();
for (int i = 0; i < A.length; i++) {

}

    for (int value : A) {
      // Add the absolute value of each element to the set
      distinctAbsValues.add(Math.abs(value));
    }

    // The size of the set will be the count of distinct absolute values
    return distinctAbsValues.size();
  }
}
