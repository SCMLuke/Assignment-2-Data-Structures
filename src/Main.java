public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insertion.
        list.insertAtEnd(2);
        list.insertAtBeginning(3);
        list.insertSorted(5);
        list.insertAtEnd(9);
        list.insertAtBeginning(7);
        list.insertSorted(15);
        list.insertAtEnd(4);
        list.insertAtBeginning(1);
        list.insertSorted(11);

        System.out.println("Original List:");
        list.display();

        // Deletion
        list.deleteFirst();
        list.deleteLast();
        list.deleteAtIndex(2);

        System.out.println("\nList after Deletion:");
        list.display();

        // Split into two sublists.
        LinkedList[] splitLists = list.frontBackSplit();
        System.out.println("\nFront List:");
        splitLists[0].display();
        System.out.println("Back List:");
        splitLists[1].display();

        // Merge two sorted lists.
        LinkedList list1 = new LinkedList();
        list1.insertAtEnd(1);
        list1.insertAtEnd(3);
        list1.insertAtEnd(5);
        LinkedList list2 = new LinkedList();
        list2.insertAtEnd(2);
        list2.insertAtEnd(4);
        list2.insertAtEnd(6);

        System.out.println("\nList 1:");
        list1.display();
        System.out.println("List 2:");
        list2.display();

        LinkedList mergedList = LinkedList.mergeLists(list1, list2);
        System.out.println("\nMerged List:");
        mergedList.display();
    }
}