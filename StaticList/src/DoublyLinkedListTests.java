import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTests {
    @Test // 1
    public void testInsert() {
        var list = createPopulatedList();

        var current = list.getFirstNode();
        assertNotNull(current);
        assertEquals(20, current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals(15, current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals(10, current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals(5, current.getData());
        assertNull(current.getNext());

        current = current.getBefore();
        assertNotNull(current);
        assertEquals(10, current.getData());

        current = current.getBefore();
        assertNotNull(current);
        assertEquals(15, current.getData());

        current = current.getBefore();
        assertNotNull(current);
        assertEquals(20, current.getData());
        assertNull(current.getBefore());
    }

    @Test // 2
    public void testSearchLastInsertedValue() {
        var list = createPopulatedList();

        var node = list.search(20);

        assertNotNull(node);
        assertEquals(20, node.getData());
    }

    @Test // 3
    public void testSearchMiddleInsertedValue() {
        var list = createPopulatedList();

        var node = list.search(10);

        assertNotNull(node);
        assertEquals(10, node.getData());
    }

    @Test // 4
    public void testRemoveLastInsertedValue() {
        var list = createPopulatedList();

        list.remove(20);

        var current = list.getFirstNode();
        assertNotNull(current);
        assertEquals(15, current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals(10, current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals(5, current.getData());
        assertNull(current.getNext());

        current = current.getBefore();
        assertNotNull(current);
        assertEquals(10, current.getData());

        current = current.getBefore();
        assertNotNull(current);
        assertEquals(15, current.getData());
        assertNull(current.getBefore());
    }

    @Test // 5
    public void testRemoveMiddleInsertedValue() {
        var list = createPopulatedList();

        list.remove(10);

        var current = list.getFirstNode();
        assertNotNull(current);
        assertEquals(20, current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals(15, current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals(5, current.getData());
        assertNull(current.getNext());

        current = current.getBefore();
        assertNotNull(current);
        assertEquals(15, current.getData());

        current = current.getBefore();
        assertNotNull(current);
        assertEquals(20, current.getData());
        assertNull(current.getBefore());
    }

    @Test // 6
    public void testRemoveFirstInsertedValue() {
        var list = createPopulatedList();

        list.remove(5);

        var current = list.getFirstNode();
        assertNotNull(current);
        assertEquals(20, current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals(15, current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals(10, current.getData());
        assertNull(current.getNext());

        current = current.getBefore();
        assertNotNull(current);
        assertEquals(15, current.getData());

        current = current.getBefore();
        assertNotNull(current);
        assertEquals(20, current.getData());
        assertNull(current.getBefore());
    }

    @Test // 7
    public void testClearList() {
        var list = createPopulatedList();

        DoublyLinkedListNode<Integer> node20 = list.search(20);
        DoublyLinkedListNode<Integer> node15 = list.search(15);
        DoublyLinkedListNode<Integer> node10 = list.search(10);
        DoublyLinkedListNode<Integer> node5 = list.search(5);

        list.clear();

        assertNull(node20.getBefore());
        assertNull(node20.getNext());

        assertNull(node15.getBefore());
        assertNull(node15.getNext());

        assertNull(node10.getBefore());
        assertNull(node10.getNext());

        assertNull(node5.getBefore());
        assertNull(node5.getNext());
    }

    public DoublyLinkedList<Integer> createPopulatedList() {
        var list = new DoublyLinkedList<Integer>();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);

        return list;
    }
}
