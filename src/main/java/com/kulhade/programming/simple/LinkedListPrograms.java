package com.kulhade.programming.simple;

public class LinkedListPrograms {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int i) {
            this.val = i;
            this.next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode sum = new ListNode(0);
        ListNode p3 = sum;
        int carry = 0;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry = carry / 10;
        }

        if (carry == 1)
            p3.next = new ListNode(carry);

        return sum.next;
    }

    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode rest = reverse(head.next);
        head.next.next=head;
        if(head!=null) {
            head.next = null;
        }
        return rest;
    }

}
