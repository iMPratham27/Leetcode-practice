
class Node {
    int data;
    Node next = null;
    Node(int data){
        this.data = data;
    }
}

class AddTwoNumbers {

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

    Node addTwoNumbers(Node l1, Node l2){
        
        Node result = new Node(0);
        Node ptr = result;
        int carry = 0;

        while(l1 != null || l2 != null){
            int sum = 0 + carry;

            if(l1 != null){
                sum += l1.data;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum/10;
            sum = sum%10;
            ptr.next = new Node(sum);
            ptr = ptr.next;
        }

        if(carry == 1) ptr.next = new Node(1);

        return result.next;
    }

    public static void main(String[] args) {
        
        AddTwoNumbers l1 = new AddTwoNumbers();
        l1.addFirst(9);
        l1.addFirst(5);
        l1.addFirst(9);
        l1.addFirst(9);
        l1.addFirst(4);
        l1.printLL(l1.head);

        AddTwoNumbers l2 = new AddTwoNumbers();
        l2.addFirst(7);
        l2.addFirst(9);
        l2.addFirst(1);
        l2.printLL(l2.head);

        AddTwoNumbers l3 = new AddTwoNumbers();
        Node ans = l3.addTwoNumbers(l1.head, l2.head);
        l3.printLL(ans);
    }
}