public class DoublyLinkedList<T> {
    private DoublyLinkedListNode<T> firstNode;
    
    public DoublyLinkedList() {
        firstNode = null;
    }

    public DoublyLinkedListNode<T> getFirst() {
        return firstNode;
    }

    public void insert(T value) {
        var newNode = new DoublyLinkedListNode<T>(value);
        newNode.setNext(firstNode);
        firstNode.setBefore(newNode);
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
        	p.getNext().setBefore(null);
        	firstNode = p.getNext();
        }
        
        if (p.getNext() == null)
    		p.getBefore().setNext(null);
        
        p.getBefore().setNext(p.getNext());
        p.getNext().setBefore(p.getBefore());
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

    public LinkedListNode<T> getNode(int index) {
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
