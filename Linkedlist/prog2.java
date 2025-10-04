
class Node {
    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
    }
}

class MyList {
    Node head = null;

    void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
}

class MergeSortedLists {

    Node mergeTwoLists(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node curr = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if (head1 != null) {
            curr.next = head1;
        } else {
            curr.next = head2;
        }

        return dummy.next;
    }

    void printLL(Node head) {
        if (head == null) {
            System.out.println("Empty LL");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print("->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyList l1 = new MyList();
        l1.addFirst(40);
        l1.addFirst(15);
        l1.addFirst(10);
        l1.addFirst(5);

        MyList l2 = new MyList();
        l2.addFirst(20);
        l2.addFirst(3);
        l2.addFirst(2);

        MergeSortedLists mll = new MergeSortedLists();

        Node result = mll.mergeTwoLists(l1.head, l2.head);
        mll.printLL(result);
    }
}