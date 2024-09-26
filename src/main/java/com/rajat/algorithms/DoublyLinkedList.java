package com.rajat.algorithms;

import com.rajat.exceptions.InvalidElementException;

public class DoublyLinkedList<E> {
     DoublyLinkedListNode<E> dummyHead;
     DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList() {
        this.dummyHead = new DoublyLinkedListNode<>(null);
        this.dummyTail = new DoublyLinkedListNode<>(null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }



    public void detachNode(DoublyLinkedListNode<E> node) {
        if(node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        if(node != null) {
           DoublyLinkedListNode tailPrev = dummyTail.prev;
           tailPrev.next = node;
           node.next = dummyTail;
           dummyTail.prev = node;
           node.prev = tailPrev;
        }
    }

    public DoublyLinkedListNode addElementAtLast(E element) {
        if(element == null) throw new InvalidElementException();
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    boolean isItemPresent() {
        return dummyHead.next != dummyTail;
    }

    public DoublyLinkedListNode<E> getFirstNode() {
        if(!isItemPresent()) return null;
        return dummyHead.next;
    }
}
