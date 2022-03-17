import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        Node head;
        Node tail;
        int size = 0;
        void createList(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if(size == 0){
                head = tail = temp;
            }
            else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        int getMid(){
            Node slow = head;
            Node fast = head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int length = scn.nextInt();
        LinkedList list = new LinkedList();
        for(int i=0; i<length; ++i){
            list.createList(scn.nextInt());
        }
        Node temp = list.head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(list.getMid());
    }
}
