import java.util.*;
import java.lang.*;
public class Main {
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        Node head;
        Node tail;
        int size = 0;
        void addLast(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if(size == 0) {
                head = tail = temp;
                size++;
            }else{
                tail.next = temp;
                tail = temp;
                size++;
            }
        }
        void removeFirst(){
            if(size == 0){
                System.out.println("The list is already empty");
            }
            else if(size == 1){
                head = tail = null;
                size = 0;
            }
            else{
                head = head.next;
                size--;
            }
        }
        public int getValue(int idx){
            Node temp = head;
            if(idx >= size || size == 0 || idx < 0){
                return -1;
            }
            else{
                int i=0;
                while(i != idx){
                    temp = temp.next;
                    i++;
                }
            }
            return temp.data;
        }
        void addFirst(int val){
            Node temp = new Node();
            temp.data = val;
            if(size == 0) {
                temp.next = null;
                head = tail = temp;
                size++;
            }
            else{
                temp.next = head;
                head = temp;
                size++;
            }
        }
        void addAtIndex(int idx){
            Node node = new Node();
            node.data = 10;
            if(idx > size){
                System.out.println("Cannot be inserted at index");
                return;
            }else if(idx == 0) {
                addFirst(10);
            }else if(idx == size){
                addLast(10);
            }else {
                Node temp = head;
                for (int i = 0; i < idx; ++i) {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
            }
            size++;
        }
        void removeLast(){
            Node temp = new Node();
            if(size == 0){
                System.out.println("List is empty");
            }
            else{
                temp = head;
                while(temp.next.next != null){
                    temp = temp.next;
                }
                temp.next = null;
                size--;
            }
        }
        void reverse(){
            Node prev = null;
            Node curr = head, temp = head;
            while(curr != null){
//                System.out.println(temp.data);
                temp = temp.next;
                curr.next =prev;
                prev = curr;
                curr = temp;
            }
            head = prev;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        for(int i=0; i<size; ++i){
            int val = scn.nextInt();
            list.addLast(val);
        }
        Node temp = list.head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        list.removeFirst();
        temp = list.head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(list.getValue(1));
        list.addFirst(0);
        System.out.println(list.head.data);
        System.out.println(list.size);

        list.addAtIndex(2);
        temp = list.head;
        for(int i=0; i<list.size; ++i){
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        list.removeLast();
        System.out.println("After removing the last element");
        temp = list.head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("After Reversing:");
        list.reverse();
        temp = list.head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
