import java.util.Arrays;

/**
 * @author : zyf
 * @since : 2019-01-05 20:40
 **/
public class Main {
    public static void main(String[] args) {

//        int[] array = {4, 2, 7, 1, 2, 6};
        int[] array = {6, 11, 3, 9, 8};

        System.out.println(Arrays.toString(array));
//        selectSort(array, array.length);
//        mergeSort(array, array.length);
        quickSort(array, array.length);
//        partition1(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    private static void selectSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            int min = a[i];
            for (int j = i; j < n; j++) {
                if (a[j] < min) {
                    int temp = a[j];
                    a[j] = min;
                    min = temp;
                }
            }
            a[i] = min;
        }
    }

    /**
     * 归并排序
     *
     * @param a 目标数组
     * @param n 数组长度
     */
    private static void mergeSort(int[] a, int n) {
        mergeRecursion(a, 0, n - 1);
    }


    private static void mergeRecursion(int[] a, int from, int to) {
        //判断递归终止条件
        if (from >= to) {
            return;
        }

        //取 from 和 to 的中间位置 middle
//        int middle = (from + to) / 2; 可能会出现 from + to 的和大于int类型最大值的情况
        int middle = from + (to - from) / 2;
        //开始分治递归
        mergeRecursion(a, from, middle);
        mergeRecursion(a, middle + 1, to);

        //将 [from...middle] 和 [middle + 1...to] 合并为 [from...to]
        merge(a, from, middle, to);
    }

    private static void merge(int[] a, int from, int middle, int to) {
        //初始化变量 i j k
        int i = from;
        int j = middle + 1;
        int k = 0;

        //申请一个大小跟 from...to 一样的数组
        int[] temp = new int[to - from + 1];
        while (i <= middle && j <= to) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        //判断哪个子数组中有剩余的数据
        int start = i;
        int end = middle;
        if (j <= to) {
            start = j;
            end = to;
        }

        //将剩余的数据拷贝到临时数组temp中
        while (start <= end) {
            temp[k++] = a[start++];
        }

        //将 temp 中的数组拷贝回 a[from...to]
        for (int l = 0; l <= to - from; l++) {
            a[from + l] = temp[l];
        }
    }


    private static void quickSort(int[] a, int n) {

        //从 0 到 数组中的最后一个元素
        quickRecursion(a, 0, n - 1);
    }

    private static void quickRecursion(int[] a, int from, int to) {
        //判断终止条件
        if (from >= to) return;
        //获取分区点
//        int partition = partition1(a, from, to);
        int partition = partition2(a, from, to);

        quickRecursion(a, from, partition - 1);
        quickRecursion(a, partition + 1, to);
    }

    /**
     * 用来获取分区点
     * 申请两个临时数组来进行分区操作
     *
     * @param a    目标数组
     * @param from 区间起点
     * @param to   区间终点
     * @return 分区点的索引
     */
    private static int partition1(int[] a, int from, int to) {
        //约定使用to位置的元素作为分区点

        //最多也就能装除了 最后一个元素的 所有元素
        //所以此处的数组 长度设定为 to（也就是 a.length-1)
        int[] lessThan = new int[to];
        int[] moreThan = new int[to];
        int lessIndex = 0;
        int moreIndex = 0;

        //a.length - 1 可以找到最后一个元素
        //但是我们将最后一个元素作为分区点使用，所以在遍历的时候就不需要遍历它了
        //只需要 0~ length-2 这些元素来与 分区点比较
        //所以这里的循环条件为 i < to
        for (int i = from; i < to; i++) {
            //如果出现于分区点 相同的元素，我们默认将它放置在 小于数组 中
            //此处按照循环顺序来添加，若出现两元素相等的情况，是不会影响到原顺序的
            //也就是说是一个稳定排序算法
            if (a[i] <= a[to]) {
                lessThan[lessIndex++] = a[i];
            }
            if (a[i] > a[to]) {
                moreThan[moreIndex++] = a[i];
            }
        }

        for (int i = 0; i < lessIndex; i++) {
            a[i] = lessThan[i];
        }

        a[lessIndex] = a[to];

        for (int i = 0; i < moreIndex; i++) {
            a[i + lessIndex + 1] = moreThan[i];
        }

        return to;
    }

    /**
     * 第二种分区方法
     * 使用两个游标来处理数据位置的交换
     * @param a
     * @param from 区间头端点
     * @param to  区间尾端点
     * @return 分区点的下标
     */
    private static int partition2(int[] a, int from, int to) {
        int pivot = a[to];
        int i = from;

        //循环过程中，游标 j 在不停的移动，游标 i 在某种情况下会移动
        //当循环完毕时，j 的位置是区间的倒数第二个元素
        // i 的位置就是 分区点应该处于的位置
        for (int j = from; j <= to - 1; j++) {
            if(a[j] <= pivot){
                //交换 a[i] 与 a[j] 的值
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;

                //移动一位
                i++;
            }
        }

        //将分区点放在 i 的位置
        //把 i 位置的元素放在 分区点原位置
        int temp = a[i];
        a[i] = a[to];
        a[to] = temp;
        return to;
    }
}
