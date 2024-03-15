public class LinkedList {
    Node head;

    // Insertion at the beginning.
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insertion at the end.
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insertion at the given location in the sorted list.
    void insertSorted(int data) {
        Node newNode = new Node(data);
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data < newNode.data) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Deletion of first node.
    void deleteFirst() {
        if (head == null)
            return;
        head = head.next;
    }

    // Deletion of last node.
    void deleteLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Deletion of given item index from sorted list.
    void deleteAtIndex(int index) {
        if (head == null || index <= 0)
            return;
        if (index == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null)
            return;
        temp.next = temp.next.next;
    }

    // Given a list, split it into two sub lists. Front half contains extra element if the number of elements is odd.
    LinkedList[] frontBackSplit() {
        LinkedList[] result = new LinkedList[2];
        result[0] = new LinkedList();
        result[1] = new LinkedList();
        if (head == null)
            return result;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            result[0].insertAtEnd(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null) {
            result[1].insertAtEnd(slow.data);
            slow = slow.next;
        }
        return result;
    }

    // Merge two sorted linked lists.
    static LinkedList mergeLists(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                mergedList.insertAtEnd(current1.data);
                current1 = current1.next;
            } else {
                mergedList.insertAtEnd(current2.data);
                current2 = current2.next;
            }
        }
        while (current1 != null) {
            mergedList.insertAtEnd(current1.data);
            current1 = current1.next;
        }
        while (current2 != null) {
            mergedList.insertAtEnd(current2.data);
            current2 = current2.next;
        }
        return mergedList;
    }

    // Display the linked list.
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
