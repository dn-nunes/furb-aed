import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTests {
    @Test // 1
    public void testEmptyList() {
        var list = new LinkedList<>();
        var isEmpty = list.isEmpty();

        assertTrue(isEmpty);
    }

    @Test // 2
    public void testNotEmptyList() {
        var list = new LinkedList<Integer>();
        list.insert(5);
        var isEmpty = list.isEmpty();

        assertFalse(isEmpty);
    }

    @Test // 3
    public void testInsertSingle() {
        var list = new LinkedList<Integer>();
        list.insert(5);
        var node = list.getFirst();

        assertEquals(5, node.getData());
        assertNull(node.getNext());
    }

    @Test // 4
    public void testInsertMultiple() {
        var list = new LinkedList<Integer>();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        var node5 = list.search(5);
        var node10 = list.search(10);
        var node15 = list.search(15);

        assertNotNull(node5);
        assertNull(node5.getNext());
        assertNotNull(node10);
        assertEquals(node5, node10.getNext());
        assertNotNull(node15);
        assertEquals(node10, node15.getNext());
    }

    @Test // 5
    public void testSearchFirstNode() {
        var list = createPopulatedList();

        var result = list.search(20);

        assertEquals(20, result.getData());
    }

    @Test // 6
    public void testSearchMiddleNode() {
        var list = createPopulatedList();
        var result = list.search(15);

        assertEquals(15, result.getData());
    }

    @Test // 7
    public void testSearchNotExistentNode() {
        var list = createPopulatedList();

        var result = list.search(50);

        assertNull(result);
    }

    @Test // 8
    public void testRemoveFirstNode() {
        var list = createPopulatedList();
        list.remove(20);

        var result = list.search(20);

        assertNull(result);
        assertEquals(3, list.getLength());
        assertEquals(15, list.getNode(0).getData());
        assertEquals(10, list.getNode(1).getData());
        assertEquals(5, list.getNode(2).getData());
    }

    @Test // 9
    public void testRemoveMiddleNode() {
        var list = createPopulatedList();
        list.remove(15);

        var result = list.search(15);
        assertEquals(3, list.getLength());
        assertEquals(20, list.getNode(0).getData());
        assertEquals(10, list.getNode(1).getData());
        assertEquals(5, list.getNode(2).getData());
    }

    @Test // 10
    public void testGetFirstNodeByIndex() {
        var list = createPopulatedList();

        var result = list.getNode(0);

        assertEquals(20, result.getData());
    }

    @Test // 11
    public void testGetLastNodeByIndex() {
        var list = createPopulatedList();

        var result = list.getNode(3);

        assertEquals(5, result.getData());
    }

    @Test // 12
    public void testGetNotExistentNodeByIndex() {
        var list = createPopulatedList();

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.getNode(10)
        );
    }

    @Test // 13
    public void testGetEmptyListLength() {
        var list = new LinkedList<Integer>();

        var result = list.getLength();

        assertEquals(0, result);
    }

    @Test
    public void testGetPopulatedListLength() {
        var list = createPopulatedList();

        var result = list.getLength();

        assertEquals(4, result);
    }



    public LinkedList<Integer> createPopulatedList() {
        var list = new LinkedList<Integer>();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);

        return list;
    }
}
