import java.util.Arrays;

public class GenericMethods implements GenericMethodsInterface {

    @Override
    public <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x) {
        Arrays.sort(a);
        return binarySearchHelper(a, x, 0, a.length - 1);
    }

    private <AnyType extends Comparable<AnyType>> int binarySearchHelper(AnyType[] a, AnyType x, int low, int high) {
        if (low > high) {
            return -1; // Element not found
        }

        int mid = (low + high) / 2;
        int cmp = x.compareTo(a[mid]);

        if (cmp == 0) {
            return mid; // Element found at index mid
        } else if (cmp < 0) {
            return binarySearchHelper(a, x, low, mid - 1); // Search in the left half
        } else {
            return binarySearchHelper(a, x, mid + 1, high); // Search in the right half
        }
    }

    @Override
    public <AnyType extends Comparable<AnyType>> int linearSearch(AnyType[] a, AnyType x) {
        for (int i = 0; i < a.length; i++) {
            if (x.compareTo(a[i]) == 0) {
                return i; // Element found at index i
            }
        }
        return -1; // Element not found
    }
}