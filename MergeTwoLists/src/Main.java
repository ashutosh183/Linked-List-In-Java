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
    }
    public  static LinkedList mergeTwoList(LinkedList l1, LinkedList l2){
        LinkedList res = new LinkedList();
        Node first = l1.head;
        Node second = l2.head;
        while(first != null && second != null){
            if(first.data <= second.data){
                res.createList(first.data);
                first = first.next;
            }else{
                res.createList(second.data);
                second = second.next;
            }
        }
        while(first != null){
            res.createList(first.data);
            first = first.next;
        }
        while(second != null){
            res.createList(second.data);
            second = second.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int length1 = scn.nextInt();
        LinkedList list1 = new LinkedList();
        for(int i=0; i<length1; ++i){
            list1.createList(scn.nextInt());
        }
        LinkedList list2 = new LinkedList();
        int length2 = scn.nextInt();
        for(int i=0; i<length2; ++i){
            list2.createList(scn.nextInt());
        }
        Node temp1 = list1.head;
        Node temp2 = list2.head;
        while(temp1 != null){
            System.out.print(temp1.data + "\t");
            temp1 = temp1.next;
        }
        System.out.println();
        while(temp2 != null){
            System.out.print(temp2.data + "\t");
            temp2 = temp2.next;
        }
        System.out.println();
        LinkedList result = mergeTwoList(list1, list2);
        Node ans = result.head;
        System.out.println("After merging two lists");
        while(ans != null){
            System.out.print(ans.data + "\t");
            ans = ans.next;
        }
    }
}

