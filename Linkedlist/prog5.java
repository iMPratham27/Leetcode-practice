package Linkedlist;

class Node {
    int data;
    Node next = null;
    Node(int data){
        this.data = data;
    }
}

class RemoveNthFromLast {

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

    int countNodes(Node head){
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    Node removeNthFromEnd(Node head, int n){
        int totalCount = countNodes(head);

        if(totalCount == n) return head.next;

        Node temp = head;
        int i = 1;
        while(i < totalCount-n){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;

        return head;
    }
    
    public static void main(String[] args) {
        
        RemoveNthFromLast rnl = new RemoveNthFromLast();
        rnl.addFirst(5);
        rnl.addFirst(4);
        rnl.addFirst(3);
        rnl.addFirst(2);
        rnl.addFirst(1);
        rnl.printLL(rnl.head);

        Node ans = rnl.removeNthFromEnd(rnl.head, 2);
        rnl.printLL(ans);
    }
}
