package data_structures.linkedlist.single;

public class add {
    static class Node {
        Node next;
        int data;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.println(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    Node addition(Node head1, Node head2) {
        Node res = new Node(0);
        Node end = res;
        int carry = 0, sum = 0;
        Node temp1 = head1, temp2 = head2;
        while (temp1 != null || temp2 != null) {
            if (temp1 == null)
                sum = temp2.data + carry;
            else if (temp2 == null)
                sum = temp1.data + carry;
            else
                sum = temp1.data + temp2.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            end.next = new Node(sum);
            end = end.next;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }
        if(carry!=0)
            end.next=new Node(carry);
        return res.next;
    }

    public static void main(String[] args) {
        add ob = new add();
        //creating 1st linked list
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        //creating 1st linked list
        //creating 2nd linked list
        Node head2 = new Node(9);
        head2.next = new Node(9);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(9);
        //creating 2nd linked list
        System.out.println("First list :");
        ob.printList(head);
        System.out.println("2nd List : ");
        ob.printList(head2);
        Node res = ob.addition(head, head2);
        System.out.println("Sum List : ");
        ob.printList(res);
    }
}
