import java.util.Arrays;

/**
 * @author : zyf
 * @since : 2019-01-05 20:40
 **/
public class Main {
    public static void main(String[] args) {

        int[] array = {4,2,3,1,2,6};

        System.out.println(Arrays.toString(array));
        selectSort(array,array.length);
        System.out.println(Arrays.toString(array));

    }

    public static void selectSort(int[] a,int n){
        if(n <= 1){
            return;
        }

        for (int i = 0; i < n; i++) {
            int min = a[i];
            for (int j = i; j < n; j++) {
                if(a[j] < min){
                    int temp = a[j];
                    a[j] = min;
                    min = temp;
                }
            }
            a[i] = min;
        }
    }
}
