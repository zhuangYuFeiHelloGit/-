import bean.Node;

import java.util.LinkedList;

/**
 * @author : zyf
 * @since : 2018-12-27 15:58
 **/
public class Main {
    public static void main(String[] args) {
        SingleLinked<String> stringSingleLinked = prepareData();

//        stringSingleLinked.addFirst("1");

//        stringSingleLinked.removeLast();

        String s = stringSingleLinked.toString();

        System.out.println(s);

        stringSingleLinked.reverse();

        s = stringSingleLinked.toString();


        System.out.println(s);

        System.out.println(stringSingleLinked.hasCircle());
    }

    private static SingleLinked<String> prepareData() {
        SingleLinked<String> singleLinked = new SingleLinked<>();
        singleLinked.addLast(new Node<>("a"));
        singleLinked.addLast(new Node<>("b"));
        singleLinked.addLast(new Node<>("c"));
        singleLinked.addLast(new Node<>("d"));
        return singleLinked;
    }
}
