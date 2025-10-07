import java.util.*;

class MergeKSortedLists {
    class ListNode {
        int data;
        ListNode next = null;
        ListNode(int data){
            this.data = data;
        }
    }

    ListNode mergeKLists(ListNode lists[]){
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.data - b.data);
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        for(ListNode node : lists){
            if(node != null){
                pq.add(node);
            }
        }

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            temp.next = min;
            temp = temp.next;

            if(min.next != null){
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}