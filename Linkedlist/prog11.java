class ReverseKGroup {
    class Node {
        int data;
        Node next = null;
        Node(int data){
            this.data = data;
        }
    }

    Node head = null;

    Node reverseKGroup(Node head, int k){
        if(head == null || k == 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;

        while(true){
            Node kth = getKthNode(prevGroupEnd, k);
            if(kth == null) break;

            Node groupStart = prevGroupEnd.next;
            Node nextGroupStart = kth.next;

            // standard reverse linked lists
            Node curr = groupStart;
            Node prev = kth.next;
            while(curr != nextGroupStart){
                Node temp = curr.next;

                curr.next = prev;

                prev = curr;
                curr = temp;
            }
            // connect with previous part
            prevGroupEnd.next = kth;

            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    Node getKthNode(Node start, int k){
        for(int i=0; i<k && start!=null; i++){
            start = start.next;
        }
        return start;
    }

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

    public static void main(String[] args) {
        
        ReverseKGroup rg = new ReverseKGroup();
        rg.addFirst(50);
        rg.addFirst(40);
        rg.addFirst(30);
        rg.addFirst(20);
        rg.addFirst(10);
        rg.printLL(rg.head);

        rg.head = rg.reverseKGroup(rg.head, 2);
        rg.printLL(rg.head);
    }
}