class Node {
    int data;
    Node next = null;

    Node(int data){
        this.data = data;
    }
}

class MyLinkedList {
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

    void printLL(){
        if(head == null){
            System.out.println("Empty LL");
            return;
        }

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.next != null) System.out.print("->");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverseLL(){
        Node prevNode = null;
        Node nextNode = null;
        Node currNode = head;

        while(currNode != null){
            nextNode = currNode.next;

            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }
}

class ReverseLL {
    
    public static void main(String[] args) {
        
        MyLinkedList ll = new MyLinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);

        ll.printLL();

        ll.reverseLL();
        ll.printLL();
    }
}