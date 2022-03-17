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

        void addLast(int val){
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
        public static Node findMid(Node head, Node tail){
            Node slow = head;
            Node fast = head;
            while(fast != tail && fast.next != tail){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        public static LinkedList mergeTwoList(LinkedList l1, LinkedList l2){
            Node first = l1.head;
            Node second = l2.head;
            LinkedList ans = new LinkedList();
            while(first != null && second != null){
                if(first.data <= second.data){
                    ans.addLast(first.data);
                    first = first.next;
                }
                else{
                    ans.addLast(second.data);
                    second = second.next;
                }
            }
            while(first != null){
                ans.addLast(first.data);
                first = first.next;
            }
            while(second != null){
                ans.addLast(second.data);
                second = second.next;
            }
            return ans;
        }
        public static LinkedList mergeSort(Node head, Node tail){
            if(head == tail){
                LinkedList br = new LinkedList();
                br.addLast(head.data);
                return br;
            }
            Node mid = findMid(head, tail);
            LinkedList firstHalf = mergeSort(head, mid);
            LinkedList secondHalf = mergeSort(mid.next, tail);
            LinkedList sortedList;
            sortedList = LinkedList.mergeTwoList(firstHalf, secondHalf);
            return sortedList;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        LinkedList list = new LinkedList();
        for(int i=0; i<size; ++i){
            list.addLast(scn.nextInt());
        }
        Node t = list.head;
        while(t != null){
            System.out.println(t.data);
            t = t.next;
        }
        LinkedList sortedList = LinkedList.mergeSort(list.head, list.tail);
        Node temp = sortedList.head;
        while(temp != null){
            System.out.print(temp.data+"\t");
            temp = temp.next;
        }

    }
}
