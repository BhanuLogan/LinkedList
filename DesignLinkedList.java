/*
    Problem Link: https://leetcode.com/problems/design-linked-list/
*/

class Node {
    int data;
    Node next;
    
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class MyLinkedList {
    Node head, tail;
    int length;

    public MyLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    // TC: O(N)    
    public int get(int index) {
        // Move pointer to index and return data in that node
        Node ptr = head;
        while(ptr != null) {
            if(index == 0) return ptr.data;
            index--;
            ptr = ptr.next;
        }
        return -1;
    }
    
    // TC: O(1)
    public void addAtHead(int val) {
        Node node = createNode(val);
        // If there is no node, assign node to head and tail
        if(head == null) {
            head = node;
            tail = node;
        } else {
            // If there are already nodes in the list,
            // make new node as head
            node.next = head;
            head = node;
        }
        length++;
    }
    
    // TC: O(1)
    public void addAtTail(int val) {
        Node node = createNode(val);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        length++;
    }
    
    // TC: O(N)
    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
        } else if(index == length) {
            addAtTail(val);
        } else if(index >= 0 && index < length) {
            // Move to index position
            // and update links
            Node node = createNode(val);
            Node prev = null;
            Node cur = head;
            while(cur != null && index > 0) {
                prev = cur;
                cur = cur.next;
                index--;
            }
            
            if(prev != null) {
                node.next = prev.next;
                prev.next = node;
                length++;
            }
        }
    }
    
    // TC: O(N)
    public void deleteAtIndex(int index) {
        if(index == 0) {
            deleteAtHead();
        } else if(index == length - 1) {
            deleteAtTail();
        } else if(index > 0 && index < length) {
            Node prev = null;
            Node cur = head;
            while(cur != null && index > 0) {
                prev = cur;
                cur = cur.next;
                index--;
            }
            prev.next = cur.next;
            length--;
        }
    }
    
    // TC: O(1)
    public int getLength() {
        return length;
    }
    
    // TC: O(1)
    public void deleteAtHead() {
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            // update head pointer to next node
            head = head.next;
        }
        length--;
    }
    
    // TC: O(1)
    public void deleteAtTail() {
        if(length == 1) {
            // If there is only one node, head and tail don't point to anything
            head = null;
            tail = null;
        } else {
            Node prev = null;
            Node cur = head;
            // This condition indicates that cur will be at last node 
            // while exiting the loop
            while(cur.next != null) {
                prev = cur;
                cur = cur.next;
            }
            if(prev != null) {
                // make last node's prev node as tail
                tail = prev;
                // point to null which means there is no node after that
                prev.next = null;
            }
        }
        length--;
    }
    
    // TC: O(1)
    private Node createNode(int val) {
        return new Node(val, null);
    }
}
