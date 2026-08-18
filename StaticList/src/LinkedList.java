public class LinkedList<T> {
    private LinkedListNode<T> firstNode;
    
    public void LinkedList() {
        firstNode = null;
    }

    public LinkedListNode<T> getFirst() {
        return firstNode;
    }

    public void insert(T value) {
        var newNode = new LinkedListNode<T>(value);
        newNode.setNext(firstNode);
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

    public LinkedListNode<T> search(T value) {
        var p = firstNode;

        while (p != null) {
            if (p.getData().equals(value))
                return p;

            p = p.getNext();
        }

        return null;
    }

    public void remove(T value) {
        LinkedListNode<T> before = null;

        var p = firstNode;
        while (p != null && (p.getData().equals(value))) {            
            before = p;
            p = p.getNext();
        }

        if (p != null) {
            if (p.equals(firstNode))
                firstNode = p.getNext();
            else
                before.setNext(p.getNext());
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

    public LinkedListNode<T> getNode(int index) {
        var c = 0;
        
        var p = firstNode;
        while (p != null && c != index)  {
            c++;

            if (p.getNext() == null)
                throw new IndexOutOfBoundsException();

            p = p.getNext();
        }

        return p;
    }


}
