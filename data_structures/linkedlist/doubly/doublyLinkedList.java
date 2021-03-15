package data_structures.linkedlist.doubly;

public class doublyLinkedList {
    static class Dnode {
        Dnode left, right;
        int data;

        Dnode(int x) {
            left = right = null;
            data = x;
        }

    }
}
