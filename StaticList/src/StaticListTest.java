import org.junit.jupiter.api.Test;

import java.awt.print.PrinterGraphics;

import static org.junit.jupiter.api.Assertions.*;

public class StaticListTest {

    @Test
    void testDataInsert() {
        var list = new StaticList<Integer>();

        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);

        assertEquals("5,10,15,20", list.toString());
    }

    @Test
    void testarListLength() {
        var list = new StaticList<Integer>();

        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);

        assertEquals(4, list.getSize());
    }

    @Test
    void testSearchExistentElement() {
        var list = new StaticList<Integer>();

        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);

        assertEquals(2, list.search(15));
    }

    @Test
    void testSearchNotExistentElement() {
        var list = new StaticList<Integer>();

        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);

        assertEquals(-1, list.search(30));
    }

    @Test
    void testRemove() {
        var list = new StaticList<Integer>();

        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);

        list.remove(10);

        assertEquals("5,15,20", list.toString());
        assertEquals(3, list.getSize());
    }

    @Test
    void testResize() {
        var list = new StaticList<Integer>();

        for (int i = 1; i <= 15; i++) {
            list.insert(i);
        }

        assertEquals(
                "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15",
                list.toString()
        );

        assertEquals(15, list.getSize());
    }

    @Test
    void testGetElement() {
        var list = new StaticList<Integer>();

        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);

        assertEquals(20, list.getElement(3));
    }

    @Test
    void testGetElementException() {
        var list = new StaticList<Integer>();

        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.getElement(5)
        );
    }

    @Test
    void testClear() {
        var list = new StaticList<Integer>();

        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);

        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    void testInvertEvenList() {
        var list = new StaticList<Integer>();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);

        list.invert();

        assertEquals(20, list.getElement(0));
        assertEquals(15, list.getElement(1));
        assertEquals(10, list.getElement(2));
        assertEquals(5, list.getElement(3));
    }

    @Test
    void testInvertUnevenList() {
        var list = new StaticList<Integer>();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);
        list.insert(25);

        list.invert();

        assertEquals(25, list.getElement(0));
        assertEquals(20, list.getElement(1));
        assertEquals(15, list.getElement(2));
        assertEquals(10, list.getElement(3));
        assertEquals(5, list.getElement(4));
    }
}