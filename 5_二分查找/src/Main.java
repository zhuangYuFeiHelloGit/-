/**
 * 二分查找演示
 *
 * @author : zyf
 * @since : 2019-01-15 11:03
 **/
public class Main {

    public static void main(String[] args) {
        int[] array = {1, 3, 6, 7, 10, 13};
        int bsearch = bsearch(array, array.length, 13);
        System.out.println(bsearch);

    }


    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int bsearch2(int[] a, int n, int target) {
        return bsearchInternally(a, 0, n - 1, target);
    }

    private static int bsearchInternally(int[] a, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);

        if (a[mid] == target) {
            return mid;
        } else if (a[mid] < target) {
            bsearchInternally(a, mid + 1, high, target);
        } else {
            bsearchInternally(a, low, mid - 1, target);
        }

        return -1;
    }
}
