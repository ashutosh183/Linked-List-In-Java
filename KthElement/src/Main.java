import java.util.*;
import java.lang.*;
public class Main {
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        Node head = null;
        Node tail = null;
        int size = 0;
        void addValue(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if(size == 0) {
                head = tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
//        void reverse(){
//            Node temp = null, prev = head, curr = head;
//            while(curr != null){
//                prev = prev.next;
//                curr.next = temp;
//                temp = curr;
//                curr = prev;
//            }
//            head = temp;
//        }
        int kthElement(int idx){
            if(idx < 0 || idx > size){
                return -1;
            }
//            reverse();
//            Node temp = head;
//            int i = 0;
//            while(i != idx){
//                i++;
//                temp = temp.next;
//            }
//            return temp.data;
            Node fast = head;
            Node slow = head;
            for(int i=0; i<idx; ++i){
                fast = fast.next;
            }
            while(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
            return slow.data;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int length = scn.nextInt();
        LinkedList list = new LinkedList();
        for(int i=0; i<length; ++i){
            list.addValue(scn.nextInt());
        }
        Node temp = list.head;
        while(temp != null){
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println("Input the kth element from end to get");
        int k = scn.nextInt();
        System.out.println(list.kthElement(k));
    }
}
