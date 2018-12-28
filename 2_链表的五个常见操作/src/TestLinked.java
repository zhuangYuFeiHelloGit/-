import bean.Node;
import org.junit.Test;

/**
 * @author : zyf
 * @since : 2018-12-28 16:33
 **/
public class TestLinked {


    /**
     * 测试在头结点前添加结点
     */
    @Test
    public void testAddFirst() {
        SingleLinked<String> t = new SingleLinked<>();
        t.addFirst("a");
        t.addFirst(new Node<>("2"));
        t.show();
    }

    /**
     * 测试在尾结点后添加结点
     */
    @Test
    public void testAddLast() {
        SingleLinked<String> t = new SingleLinked<>();
        t.addLast("a");
        t.addLast(new Node<>("2"));
        t.show();
    }
    /**
     * 测试删除尾结点
     */
    @Test
    public void testRemoveLast() {
        SingleLinked<String> t = prepareData();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
//        t.removeLast();
        t.show();
    }

    /**
     * 测试删除头结点
     */
    @Test
    public void testRemoveFirst() {
        SingleLinked<String> t = prepareData();
        t.removeFirst();
        t.removeFirst();
        t.removeFirst();
        t.removeFirst();
//        t.removeFirst();
        t.show();
    }

    /**
     * 测试反转
     */
    @Test
    public void testReverse() {
        SingleLinked<String> t = prepareData();
        t.removeFirst();
        t.removeFirst();  //有两个结点情况
//        t.removeFirst();  //至有一个头结点情况
//        t.removeFirst(); //无结点情况
        t.reverse().show();
    }

    /**
     * 测试是否有环
     */
    @Test
    public void testHasCircle() {
        SingleLinked<String> t = prepareData();
        System.out.println("t 是否有环：" + t.hasCircle());
        SingleLinked<String> y = prepareCircleData();
        System.out.println("y 是否有环：" + y.hasCircle());

    }


    /**
     * 测试升序数据 a ，b
     */
    @org.junit.Test
    public void testASC() {
        SingleLinked<Integer> a = prepareInt(new int[]{1, 3, 5, 7, 9});
        SingleLinked<Integer> b = prepareInt(new int[]{0, 2, 4, 6, 8});

        SingleLinked<Integer> merge = SingleLinkedUtil.mergeOrderedLinked(a, b);

        merge.show();

    }

    /**
     * 测试降序数据 a ，b
     */
    @org.junit.Test
    public void testDES() {
        SingleLinked<Integer> a = prepareInt(new int[]{9, 7, 5, 3, 1});
        SingleLinked<Integer> b = prepareInt(new int[]{8, 6, 4, 2, 0});

        SingleLinked<Integer> merge = SingleLinkedUtil.mergeOrderedLinked(a, b);

        merge.show();
    }


    /**
     * 测试：删除链表倒数第 n 个结点
     */
    @Test
    public void testDelFromEnd(){
        SingleLinked<String> singleLinked = prepareData();
        singleLinked.removeAtFromEnd2(6);
        singleLinked.show();
    }

    /**
     * 测试：获得链表的中间结点
     */
    @Test
    public void testGetMiddle(){
        SingleLinked<String> singleLinked = prepareData();
        Node<String> middleNode = singleLinked.getMiddleNode();
        System.out.println(middleNode.getT());


    }


    private static SingleLinked<Integer> prepareInt(int[] array) {
        SingleLinked<Integer> singleLinked = new SingleLinked<>();

        for (int i = 0; i < array.length; i++) {
            singleLinked.addLast(new Node<>(array[i]));
        }

        return singleLinked;
    }

    private static SingleLinked<String> prepareData() {
        SingleLinked<String> singleLinked = new SingleLinked<>();
        singleLinked.addLast("a");
        singleLinked.addLast("b");
        singleLinked.addLast("c");
        singleLinked.addLast("d");
        singleLinked.addLast("e");
        return singleLinked;
    }


    private SingleLinked<String> prepareCircleData() {

        SingleLinked<String> singleLinked = new SingleLinked<>();
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        singleLinked.addLast(a);
        singleLinked.addLast(b);
        singleLinked.addLast(c);
        singleLinked.addLast(d);
        singleLinked.addLast(e);
        singleLinked.addLast(f);

        //f 指向了 c
        /**
         *  a -> b -> c -> d -> e -> f
         *            |             |
         *            <-------------
         */
        f.setNext(c);
        return singleLinked;
    }

}
