import java.util.LinkedList;

/**
 * @author : zyf
 * @since : 2018-12-26 16:49
 **/
public class T {


    public static void main(String[] args) {

        //准备数据
        Node headNode = prepData();
        //获取中结点
        Node middleNode = getMiddleNode(headNode);
        //将后半段逆序
        Node reverseNode = reverseNode(middleNode);
        //判断是否为回文
        boolean palindrome = isPalindrome(headNode, reverseNode);
        //逆序复原
        middleNode = reverseNode(reverseNode);
        System.out.println(palindrome);

    }

    public static void showNodes(Node headNode){
        Node result = null;
        while ( headNode != null){

            System.out.println(headNode.getValue());
            headNode = headNode.getNext();
        }
    }


    public static Node prepData(){
        //拼接链表：
        Node headNode = new Node(0);
        Node current = headNode;
        int[] a = {1,2,3,4,4,3,2,1,0};
        for (int i = 0; i < 9; i++) {
            Node temp = new Node(a[i]);
            current.setNext(temp);
            current = temp;
        }
        return headNode;
    }

    public static Node getMiddleNode(Node headNode){
        Node lowlyNode = headNode.getNext();
        Node fastNode = null;
        if(lowlyNode != null){
            fastNode = lowlyNode.getNext();
        }
        while (fastNode != null){
            if(fastNode.getNext() == null){
                //说明链表长度为奇数
                //说明此时lowlyNode为中间结点
                return lowlyNode;
            }

            if(fastNode.getNext().getNext() == null){
                //说明链表长度为偶数
                //此时应该根据规定（看你的需求）来返回上中结点还是下中结点
                //假设链表长度为4（0，1，2，3）
                //上中结点就是1，下中结点就是2
                //此处我返回下中结点
                return lowlyNode.getNext();
            }
            //每次循环，快指针前进两步
            fastNode = fastNode.getNext();
            fastNode = fastNode.getNext();
            //每次循环，慢指针前进一步
            lowlyNode = lowlyNode.getNext();
        }

        return lowlyNode;
    }

    public static Node reverseNode(Node head){
        Node temp = head.getNext();
        Node flag = temp.getNext();

        head.setNext(null);

        while (flag != null){
            temp.setNext(head);

            //temp 变成了头
            head = temp;
            //flag 变成了 temp
            temp = flag;

            flag = flag.getNext();
        }

        temp.setNext(head);
        return temp;
    }

    public static Node reverseNodeByRecursion(Node head,Node next){
        if(next == null){
            return head;
        }

        if(head.getNext().equals(next)){
            //第一次进来
            //把头结点变为尾结点
            head.setNext(null);
        }

        if(next.getNext() != null){
            //说明还没有遍历完毕
            Node next2 = next.getNext();
            next.setNext(head);

            return reverseNodeByRecursion(next,next2);
        }

        next.setNext(head);
        return next;

    }

    /**
     * @param head  头结点
     * @param middleHead <p>若链表长度为奇数，则在中间结点的 next 结点开始逆序，
     *                   若链表长度为偶数，则在下中结点开始逆序<p/>
     * @return
     */
    public static boolean isPalindrome(Node head,Node middleHead){

        /**
         * middleHead肯定是在head后面的
         * 也就是 middleHead 会先走到结尾，所以此处用 middleHead 来判断
         */
        while (middleHead != null){
            if(head.getValue() != middleHead.getValue()){
                return false;
            }

            head = head.getNext();
            middleHead = middleHead.getNext();
        }

        return true;
    }

}
