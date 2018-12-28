import bean.Node;
import exception.CannotControlException;
import exception.UnorderedLinkedException;

/**
 * @author : zyf
 * @since : 2018-12-28 15:55
 **/
public class SingleLinkedUtil {

    private static final int ASC = 0;
    private static final int DES = 1;
    private static final int NULL_LINKED = 2;//表示空链表
    private static final int UNORDERED = -1;


    /**
     * 判断链表是否有序
     * @param linked
     * @return 是升序还是降序
     */
    public static int isOrderLinked(SingleLinked<Integer> linked){
        Node<Integer> first = linked.getFirst();
        if(first == null){
            return NULL_LINKED;
        }

        Node<Integer> next = first.getNext();

        //0 表示升序
        //1 表示返序
        int flag = UNORDERED;

        while (next != null){
            if(next.getT() >= first.getT()){
                //大于 则 flag 为0

                if(flag == UNORDERED){
                    //说明是第一次判断
                    flag = ASC;
                }else {
                    if(flag != ASC){
                        //说明在循环中的某一次将 flag 的值改为 1 了
                        //说明不是一个有序链表
                        return UNORDERED;
                    }else {
                        first = next;
                        next = next.getNext();
                    }
                }
            }else {
                //小于 则 flag 为 1
                if(flag == -1){
                    flag = DES;
                }else {
                    if(flag != DES){
                        return UNORDERED;
                    }else {
                        first = next;
                        next = next.getNext();
                    }
                }
            }

        }

        return flag;
    }

    public static SingleLinked<Integer> mergeOrderedLinked(SingleLinked<Integer> a,SingleLinked<Integer> b){
        //先判断 a,b 是否有序
        int aOrder = SingleLinkedUtil.isOrderLinked(a);
        int bOrder = SingleLinkedUtil.isOrderLinked(b);
        if(aOrder == NULL_LINKED){
            return b;
        }

        if(bOrder == NULL_LINKED){
            return a;
        }

        SingleLinked<Integer> result = new SingleLinked<Integer>();

        if(aOrder != UNORDERED && bOrder != UNORDERED){
            if(aOrder != bOrder){
                //说明两者的排序方式不一样
                throw new CannotControlException();
            }else {

                if(aOrder == ASC){
                    //说明两个链表都是升序
                    //通过递归的方式合并两个链表
                    result.addLast(mergeASC(a.getFirst(), b.getFirst()));

                }else {
                    //说明两个链表都是降序
                    result.addLast(mergeDES(a.getFirst(), b.getFirst()));
                }
            }


        }else {
            throw new UnorderedLinkedException();
        }


        return result;
    }

    /**
     * 合并升序链表
     * @param nodeA
     * @param nodeB
     * @return
     */
    private static Node<Integer> mergeASC(Node<Integer> nodeA,Node<Integer> nodeB){
        Node<Integer> result;
        if(nodeA == null){
            return nodeB;
        }

        if(nodeB == null){
            return nodeA;
        }

        if(nodeA.getT() < nodeB.getT()){
            result = nodeA;
            result.setNext(mergeASC(nodeA.getNext(),nodeB));
        }else {
            result = nodeB;
            result.setNext(mergeASC(nodeA,nodeB.getNext()));
        }

        return result;
    }

    /**
     * 合并降序链表
     * @param nodeA
     * @param nodeB
     * @return
     */
    private static Node<Integer> mergeDES(Node<Integer> nodeA,Node<Integer> nodeB){
        Node<Integer> result;

        if(nodeA == null){
            return nodeB;
        }

        if(nodeB == null){
            return nodeA;
        }

        if(nodeA.getT() > nodeB.getT()){
            result = nodeA;

            result.setNext(mergeDES(nodeA.getNext(),nodeB));
        }else {
            result = nodeB;
            result.setNext(mergeDES(nodeA,nodeB.getNext()));
        }

        return result;
    }
}
