package com.zipcodewilmington.singlylinkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    public void testAdd() {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>("test");
        sll.add("test1");

        assertEquals(2, sll.size());
    }

    @Test
    public void testRemove() {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>("test");
        sll.add("test1");
        sll.add("test2");
        sll.add("test3");

        assertEquals(4, sll.size());

        sll.remove("test2");
        assertEquals(3, sll.size());
        assertEquals(-1, sll.find("test2"));
    }

    @Test
    public void testContains() {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>("test");
        SinglyLinkedList<Integer> sll1 = new SinglyLinkedList<>(1);

        assertTrue(sll.contains("test"));
        assertFalse(sll.contains("test1"));

        assertTrue(sll1.contains(1));
        assertFalse(sll1.contains(2));
    }

    @Test
    public void testFind() {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>("test");
        sll.add("test1");
        sll.add("test2");
        sll.add("test3");

        assertEquals(0, sll.find("test"));
        assertEquals(1, sll.find("test1"));
        assertEquals(2, sll.find("test2"));
        assertEquals(3, sll.find("test3"));
        assertEquals(-1, sll.find("test4"));
    }

    @Test
    public void testSize() {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>("test");
        sll.add("test1");
        sll.add("test2");
        sll.add("test3");

        assertEquals(4, sll.size());
    }

    @Test
    public void testGet() {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>("test");
        sll.add("test1");
        sll.add("test2");
        sll.add("test3");

        assertEquals("test2", sll.get(2));
        assertNull(sll.get(4));
    }

    @Test
    public void testCopy() {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>("test");
        sll.add("test1");
        sll.add("test2");
        sll.add("test3");

        SinglyLinkedList<String> sllNew = sll.copy();

        for (int i = 0; i < sllNew.size(); i++) {
            assertEquals(sll.get(i), sllNew.get(i));
        }

        sllNew.remove("test");

        for (int i = 0; i < sllNew.size(); i++) {
            assertNotEquals(sll.get(i), sllNew.get(i));
        }
    }

    @Test
    public void testSort() {
    }
}
