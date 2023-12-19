package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> current;
    private int size;
    public SinglyLinkedList(T object) {
        this.head = new Node<>(object);
        this.current = head;
        this.size = 1;
    }
    public void add(T object) {
        Node<T> node = new Node<>(object);
        current.setNext(node);
        node.setPrevious(current);
        this.current = node;
        this.size++;
    }
    public void remove(T object) {
        Node<T> checkNode = this.head;
        while (true) {
            if (checkNode.getObject().equals(object)) {
                if (checkNode.getPrevious() == null) {
                    this.head = checkNode.getNext();
                    this.size--;
                } else {
                    checkNode.getPrevious().setNext(checkNode.getNext());
                    this.size--;
                }
                break;
            } else {
                if (checkNode.getNext() != null) {
                    checkNode = checkNode.getNext();
                } else {
                    break;
                }
            }
        }
    }
    public boolean contains(T object) {
        Node<T> checkNode = this.head;
        while (true) {
            if (checkNode.getObject().equals(object)) {
                return true;
            } else {
                if (checkNode.getNext() != null) {
                    checkNode = checkNode.getNext();
                } else {
                    break;
                }
            }
        }
        return false;
    }
    public int find(T object) {
        Node<T> checkNode = this.head;
        int index = 0;
        while (true) {
            if (checkNode.getObject().equals(object)) {
                return index;
            } else {
                if (checkNode.getNext() != null) {
                    checkNode = checkNode.getNext();
                    index++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }
    public int size() { return this.size; }
    public T get(int index) {
        Node<T> checkNode = this.head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return checkNode.getObject();
            } else {
                if (checkNode.getNext() != null) {
                    checkNode = checkNode.getNext();
                } else {
                    break;
                }
            }
        }
        return null;
    }
    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> sllNew = new SinglyLinkedList<>(this.head.getObject());
        for (int i = 1; i < this.size(); i++) {
            sllNew.add(this.get(i));
        }
        return sllNew;
    }
    public void sort() {}

    class Node<T> {

        private T object;
        private Node<T> next;
        private Node<T> previous;

        public Node(T object) {
            this.object = object;
            this.next = null;
            this.previous = null;
        }

        public void setPrevious(Node<T> node) {
            this.previous = node;
        }

        public Node<T> getPrevious() {
            return this.previous;
        }
        public void setNext(Node<T> node) {
            this.next = node;
        }

        public Node<T> getNext() {
            return this.next;
        }
        public T getObject() {
            return object;
        }

    }
}
