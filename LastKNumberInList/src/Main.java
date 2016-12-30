/**
 * Created by Wenjian on 2016/12/30, 0030.
 */

import java.util.Scanner;

/**
 * the last K-th number in a list
 * this list should be build by myself
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();/*length of list*/

        /*elements of list*/
        ListNode current = null;
        ListNode head = null;
        for(int i = 0; i < num; i++){
            /*build a new node*/
            ListNode newNode = new ListNode();
            newNode.setVal(sc.nextInt());
            newNode.setNext(null);
            /*link to the list*/
            if(current == null){
                head = newNode;/*first node*/
                current = newNode;
            }
            else{/*others, link it*/
                current.setNext(newNode);
                current = current.getNext();
            }
        }

        /*the last k-th number, start from 0*/
        int k = sc.nextInt();
        /*make sure k is less than num*/
        int lastK = getLastKthElement(head, k);
        System.out.println(lastK);
    }

    /**
     *
     * @param head, list first node
     * @param k, from 0, last k-th element
     * @return
     * we will use two reference, their difference is k
     */
    private static int getLastKthElement(ListNode head, int k){
        ListNode first = head;
        ListNode second = head;
        /*move k step*/
        for(int i = 0; i <= k; i++){
            second = second.getNext();
        }
        /*move first and second until second is null*/
        while(second != null){
            first = first.getNext();
            second = second.getNext();
        }
        return first.getVal();
    }

    /**
     * list node class
     */
    static class ListNode{
        private int val;
        private ListNode next;
        public void setVal(int val){ this.val = val; }
        public int getVal(){ return this.val; }
        public void setNext(ListNode next){ this.next = next; }
        public ListNode getNext(){ return this.next; }
    }
}
