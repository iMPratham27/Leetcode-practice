
class Node {

    int data;
    Node next = null;
    Node(int data){
        this.data = data;
    }
}

class ReorderList {

    Node head = null;

    void addFirst(int data){

        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    void printLL(Node head){
        if(head == null){
            System.out.println("Empty");
            return;
        }

        Node temp = head;
        System.out.print("head->");
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    void reorderList(Node head){
        if(head == null || head.next == null) return;

        Node slow = head;
        Node fast = head;
        // find middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // now slow will be middle

        Node first = head;
        Node second = reverse(slow.next);
        slow.next = null;

        // merge
        while(second != null){
            Node i = first.next;
            Node j = second.next;

            first.next = second;
            second.next = i;

            first = i;
            second = j;
        }
    }

    Node reverse(Node head){
        Node prev = null;
        Node next = null;
        Node curr = head;
        while(curr != null){
            next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
    
    public static void main(String[] args) {
        
        ReorderList rl = new ReorderList();
        rl.addFirst(5);
        rl.addFirst(4);
        rl.addFirst(3);
        rl.addFirst(2);
        rl.addFirst(1);
        rl.printLL(rl.head);

        rl.reorderList(rl.head);
        rl.printLL(rl.head);
    }
}
