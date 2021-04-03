package MyLlist;

import MyAList.Ilist;


public class LList implements Ilist {

    public static class Node {
        Object data;
        Node next;
    }

    public LList() {
    }

    Node head;
    Node tail;

    int size;


    @Override
    public void clear() { // done
        Node node = head;
        while (node != null) {
            node.data = null;
            node = node.next;
        }
    }

    @Override
    public int size() { // done
        return size;
    }

    @Override
    public int get(int index) { // done
        if (index > size) {
            System.out.println("No such index in the list");
            return 0;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return (Integer) node.data;
    }


    @Override
    public boolean add(int value) { // done
        Node node = new Node();
        node.data = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return false;
    }


    @Override
    public boolean add(int index, int value) { // done
        if (index > size()) {
            System.out.println("No such index in the list");
            return false;
        }

        Node current = head;
        int pos = 0;
        Node node = new Node();
        node.data = value;
        if (index == 0) {
            node.next = head;
            head = node;
            size++;
            return true;
        }
        while (current.next != null) {
            if (pos == index - 1) {
                break;
            }
            pos++;
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
        return true;
    }

    @Override
    public int remove(int number) {
        Node node = head;
        int temp = 0;
        for (int i = 1; i < size; i++) {
            node = node.next;
            if (number == (int) node.data) {
                temp = i;
                break;
            }
        }
        Node nodePrev = head;
        Node nodeNext = head;
        for (int i = 0; i < temp - 1; i++) {
            nodePrev = nodePrev.next;
        }
        for (int i = 0; i < temp; i++) {
            nodeNext = nodeNext.next;
        }
        nodePrev.next = nodeNext.next;
        return size--;
    }

    @Override
    public int removeByIndex(int index) { // done
        if (index > size) {
            System.out.println("No such index in the list");
        }
        Node nodePrev = head;
        Node nodeNext = head;
        if (index == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                nodePrev = nodePrev.next;
            }
            for (int i = 0; i < index; i++) {
                nodeNext = nodeNext.next;
            }
            nodePrev.next = nodeNext.next;

        }
        return size--;
    }

    @Override
    public boolean contains(int value) { // done
        Node node = head;
        while (node.next != null) {
            if ((Integer) node.data == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean set(int index, int value) { // done
        if (index > size) {
            System.out.println("No such index in the list");
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.data = value;
        return true;
    }

    @Override
    public void print() { // done
        Node n = head;
        while (n.next != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.print(n.data);
    }


    @Override
    public int[] toArray() {
        Node current = head;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            if (current.data != null) {
                array[i] = (int) current.data;
                current = current.next;
            } else {
                array = new int[]{};
            }
        }
        return array;
    }

    @Override
    public boolean removeAll(int[] ar) {
       Node node = head;
        for (int i = 0; i < ar.length; i++) {
            node = head;
            while (node.next != null) {
                if ((int) node.data == ar[i]) {
                    remove((int) node.data);
                }
                node = node.next;
            }
            if ((int) node.data == ar[i]) {
                remove((int) node.data);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        LList lList = new LList();
        lList.add(5);
        lList.add(7);
        lList.add(4);
        lList.add(9);
        lList.add(15);
        lList.add(19);
        int[] ar = new int[]{4, 15, 19};
        lList.removeAll(ar);
        lList.print();
    }
}


