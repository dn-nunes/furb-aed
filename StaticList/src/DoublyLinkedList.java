public class DoublyLinkedList<T> {
    private DoublyLinkedListNode<T> firstNode;
    
    public DoublyLinkedList() {
        firstNode = null;
    }

    public DoublyLinkedListNode<T> getFirstNode() {
        return firstNode;
    }

    public void insert(T value) {
        var newNode = new DoublyLinkedListNode<T>(value);

        newNode.setNext(firstNode);
        if (firstNode != null) {
            firstNode.setBefore(newNode);
        }
        firstNode = newNode;
    }

    public void show() {
        var p = firstNode;

        while (p != null) {
            System.out.println(p.getData());
            p = p.getNext();
        }
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public DoublyLinkedListNode<T> search(T value) {
        var p = firstNode;

        while (p != null) {
            if (p.getData().equals(value))
                return p;

            p = p.getNext();
        }

        return null;
    }

    public void remove(T value) {
        var p = search(value);

        if (p == null)
        	return;

        if (firstNode.equals(p)) {
            firstNode = p.getNext();
        }

        if (p.getBefore() != null)
            p.getBefore().setNext(p.getNext());

        if (p.getNext() != null)
            p.getNext().setBefore(p.getBefore());
    }

    public void showInvertered() {
        var p = firstNode;

        while (p.getNext() != null) {
            p = p.getNext();
        }

        while (p != null) {
            System.out.println(p.getData());
            p = p.getBefore();
        }
    }

    public void clear() {
        var p = firstNode;
        DoublyLinkedListNode<T> nextNode = null;

        while (p != null) {
            nextNode = p.getNext();
            p.setBefore(null);
            p.setNext(null);
            p = nextNode;
        }
    }

    public int getLength() {
        var c = 0;

        var p = firstNode;
        while (p != null)  {
            c++;
            p = p.getNext();
        }

        return c;
    }

    public DoublyLinkedListNode<T> getNode(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        var c = 0;
        var p = firstNode;

        while (p != null && c < index) {
            p = p.getNext();
            c++;
        }

        if (p == null) {
            throw new IndexOutOfBoundsException();
        }

        return p;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        var p = firstNode;

        while (p != null) {
            sb.append(p.getData());
            if (p.getNext() != null) {
                sb.append(", ");
            }
            p = p.getNext();
        }

        return sb.toString();
    }
}
