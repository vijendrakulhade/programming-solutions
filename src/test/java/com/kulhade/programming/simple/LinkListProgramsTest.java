package com.kulhade.programming.simple;


import org.junit.jupiter.api.Test;

public class LinkListProgramsTest {

    LinkedListPrograms linkedListPrograms = new LinkedListPrograms();

    @Test
    public void testReverse(){
        LinkedListPrograms.ListNode head = new LinkedListPrograms.ListNode(1);
        head.next = new LinkedListPrograms.ListNode(2);
        head.next.next = new LinkedListPrograms.ListNode(3);
        linkedListPrograms.reverse(head);
    }
}
