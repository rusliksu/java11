package JosephusPermutation;

import java.util.*;

public class Josephus {

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> permutation = new ArrayList<>();
        int position = 0;
        while (items.size() != 0) {
            position = (position + k - 1) % items.size();
            permutation.add(items.remove(position));
        }
        return permutation;
    }

    public static void main(String[] args) {
        System.out.println(josephusPermutation(new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), 3));
    }
}
