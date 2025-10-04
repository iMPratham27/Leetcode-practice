
import java.util.*;

class Node {
    int val;
    Node next = null;
    Node random = null;
    Node(int val){
        this.val = val;
    } 
}

class CopyListWithRandomPointer {

    Node head = null;
    
    Node copyRandomList(Node head){
        if(head == null) return null;

        // create new list
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;

            curr = newNode.next;
        }

        // copy random pointer
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        //separate two lists
        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        while(curr != null){
            curr.next = newCurr.next;
            curr = curr.next;

            if(curr != null){
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        } 

        return newHead;
    }

    
    Node copyRandomListUsingMap(Node head){
        if(head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        // create all nodes and store in map
        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.val));
            
            curr = curr.next;
        }

        // copy next and random pointer
        curr = head;
        while(curr != null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}
