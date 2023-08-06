// remove the duplicate element from the array
import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 2, 3, 5};

    
    HashSet<Integer> set = new HashSet<>();
    for (int element : array) {
      set.add(element);
    }

    
    int[] result = new int[set.size()];
    int i = 0;
    for (int element : set) {
      result[i++] = element;
    }

    System.out.println(Arrays.toString(result));
  }
}
