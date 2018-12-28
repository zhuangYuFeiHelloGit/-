import bean.Node;
import org.junit.Test;

/**
 * @author : zyf
 * @since : 2018-12-28 16:33
 **/
public class TestSort {

    /**
     * 测试准备升序数据 a ，b
     */
    @Test
    public void testASC(){
        SingleLinked<Integer> a = prepareInt(new int[]{1, 3, 5, 7, 9});
        SingleLinked<Integer> b = prepareInt(new int[]{0, 2, 4, 6, 8});

        SingleLinked<Integer> merge = SingleLinkedUtil.mergeOrderedLinked(a, b);

        merge.show();

    }

    public static void main(String[] args) {







    }

    private static SingleLinked<Integer> prepareInt(int[] array) {
        SingleLinked<Integer> singleLinked = new SingleLinked<>();

        for (int i = 0; i < array.length; i++) {
            singleLinked.addLast(new Node<>(array[i]));
        }

        return singleLinked;
    }

}
