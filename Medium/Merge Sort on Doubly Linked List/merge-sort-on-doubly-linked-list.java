//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        // If the list is empty or has only one element, it's already sorted.
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find the middle node of the list.
        Node mid = getMid(head);
        
        // Recursively sort the two halves.
        Node l1 = sortDoubly(head);
        Node l2 = sortDoubly(mid);
        
        // Merge the sorted halves.
        return merge(l1, l2);
    }
    
    // Function to find the middle node of a doubly linked list.
    static Node getMid(Node head) {
        // Using Floyd's Tortoise and Hare algorithm to find the middle.
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Separate the list into two halves and return the middle node.
        Node mid = slow.next;
        slow.next = null; // Break the link at mid.
        mid.prev = null; // Reset previous pointer for mid.
        return mid;
    }
    
    // Function to merge two sorted doubly linked lists.
    static Node merge(Node l1, Node l2) {
        // If one list is null, return the other.
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        // Initialize a dummy node as the head of the merged list.
        Node dummyHead = new Node(-1);
        Node tail = dummyHead; // Track the tail of the merged list.
        
        // Merge the two lists.
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                // Append node from l1 to the merged list.
                l1.prev = tail;
                tail.next = l1;
                l1 = l1.next;
            } else {
                // Append node from l2 to the merged list.
                l2.prev = tail;
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next; // Move tail to the last node.
        }
        
        // Append the remaining nodes from either list.
        if (l1 != null) {
            l1.prev = tail;
            tail.next = l1;
        }
        if (l2 != null) {
            l2.prev = tail;
            tail.next = l2;
        }
        
        // Skip the dummy head and update the previous pointer of the new head.
        Node head = dummyHead.next;
        head.prev = null;
        
        // Return the head of the merged list.
        return head;
    }
}