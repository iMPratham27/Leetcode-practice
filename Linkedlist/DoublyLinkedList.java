
class DLLNode {
    int data;
    DLLNode next = null;
    DLLNode prev = null;
    DLLNode(int data){
        this.data = data;
    }
}

class DoublyLinkedList {
    
    DLLNode head = null;

    void addFirst(int data){
        DLLNode newNode = new DLLNode(data);

        if(head == null){
            head = newNode; // Head points to the entire node, not to its prev.
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addLast(int data){
        DLLNode newNode = new DLLNode(data);

        if(head == null){
            head = newNode;
        }else{
            DLLNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    void deleteFirst(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        if(head.next == null){
            head = null;
        }else{
            head = head.next;
            head.prev = null;
        }
    }

    void deleteLast(){
        if(head == null){
            System.out.println("Empty");
            return;
        }

        if(head.next == null){
            head = null;
        }else{
            DLLNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.prev.next = null;
            temp.prev = null;
        }
    }

    int countNodes(DLLNode head){
        int count = 0;

        DLLNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    void printDLL(DLLNode head) {
        if (head == null) {
            System.out.println("Empty DLL");
            return;
        }

        DLLNode temp = head;
        System.out.print("head->");
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print("->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(30);
        dll.addFirst(20);
        dll.addFirst(10);
        dll.printDLL(dll.head);

        dll.addLast(5);
        dll.addLast(15);
        dll.printDLL(dll.head);

        dll.deleteFirst();
        dll.printDLL(dll.head);

        dll.deleteLast();
        dll.printDLL(dll.head);
    }
}
