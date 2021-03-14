//TC: O(M+N) - We are iterating through all the elements.
//SC: O(1) - We are not using any auxilary space.

public class MergeSortedArray_88 {

    public int[] mergeArray(int[] arrayOne, int oneLength, int[] arrayTwo, int secondLength) {

        int firstPointer = oneLength - 1;
        int secondPointer = secondLength - 1;
        int index = oneLength + secondLength - 1; // Since question mentioned 0 will be in the first array. We have to
                                                  // replace the
        // elements in the first array.

        // Check all the elements from right to left. This will merge the second array
        // to the first array.
        while (firstPointer >= 0 && secondPointer >= 0) {
            int firstElement = arrayOne[firstPointer];
            int secondElement = arrayTwo[secondPointer];
            if (secondElement > firstElement) {
                arrayOne[index] = secondElement; // Replacing the lesser value with the bigger element from the array
                                                 // two.
                secondPointer--; // Decrement the second last point 
            } else {
                arrayOne[index] = firstElement;
                firstPointer--;
            }
            index--;
        }
        while (secondPointer >= 0) { // First array have empty space but second array has sum values.
            arrayOne[index] = arrayTwo[secondPointer];
            secondPointer--;
            index--;
        }

        return arrayOne;
    }

    public static void main(String[] args) {
        MergeSortedArray_88 mergeSortedArray_23 = new MergeSortedArray_88();
        // int[] arrayOne = new int[] { 1, 2, 3, 0, 0, 0 };
        // int[] arrayTwo = new int[] { 2, 5, 6 };
        // int[] resultArray = mergeSortedArray_23.mergeArray(arrayOne, 3, arrayTwo, 3);

        int[] arrayOne = new int[] { 0 };
        int[] arrayTwo = new int[] { 1 };
        int[] resultArray = mergeSortedArray_23.mergeArray(arrayOne, 0, arrayTwo, 1);
        System.out.println(resultArray);
    }
}
