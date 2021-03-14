import java.util.*;

//TC: O(N) - Iterating all the elements in the given array.
//SC: O(1) - We are not using any auxilary variables and we are modifing the given array.
class RemoveDuplicates_80 {

    public int removeDuplicatesBruteForce(int[] array) {
        // TC: O(N) - Iterating all the elements in the given array.
        // SC: O(N) - Since we are using hashmap.

        if (array == null || array.length == 0)
            return 0;

        int result = 0;
        int max_allowed_duplicates = 2;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int count = map.get(array[i]);
                if (count < max_allowed_duplicates) {
                    count += 1;
                    map.put(array[i], count);
                    result++;
                }
            } else {
                map.put(array[i], 1);
                result++;
            }
        }
        return result;
    }

    public int removeDuplicates(int[] array) {
        // Slow pointer purpose: Po proper index - allowed number of duplicates.
        // Fast pointer purpose - visit all the element - If duplicate increment only
        //                        the fast pointer.

        int maxAllowedDuplicates = 2; // Dynamic way. But the question asked atmost 2 elements. So hardcoded value of
                                      // 2.

        int slowPointer = 1;
        int fastPointer = 1;
        int previousIndex = 0;
        int count = 1;

        while (fastPointer < array.length) {
            if (array[previousIndex] == array[fastPointer]) { // Check if it is duplicate or not.
                // Duplicate found. Check if we already found it or not - Since the question
                // mentioned max 2 duplicates allowed. We are using a boolean property.
                if (count < maxAllowedDuplicates) {
                    count++;
                    slowPointer++;
                    fastPointer++;
                    swap(array, slowPointer, fastPointer);
                } else {
                    fastPointer++;
                }
            } else {
                previousIndex = fastPointer;
                swap(array, slowPointer, fastPointer);
                count = 1; // Reset the counter as we found a new element.
                slowPointer++;
                fastPointer++;
            }
        }
        return slowPointer;
    }

    private int[] swap(int[] array, int sp, int fp) {
        array[sp] = array[fp];
        return array;
    }

    public static void main(String[] args) {
        RemoveDuplicates_80 removeDuplicates_80 = new RemoveDuplicates_80();
        int[] array = new int[] { 1, 1, 1, 2, 2, 2, 3 };
        int number = removeDuplicates_80.removeDuplicates(array);
        Arrays.toString(array);
    }
}