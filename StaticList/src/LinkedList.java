public class LinkedList {
    private LinkedListNode firstNode;
    
    public void LinkedList() {
        firstNode = null;
    }

    public LinkedListNode getFirst() {
        return firstNode;
    }

    public void Insert(int value) {
        var newNode = new LinkedListNode(value);
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
        if (firstNode == null) {
            return true; 
        }

        return false;
    }

    public LinkedListNode search(int value) {
        var p = firstNode;

        while (p != null) {
            if (p.getData() == value)
                return p;

            p = p.getNext();
        }

        return null;
    }

    public void remove(int value) {
        LinkedListNode before = null;

        var p = firstNode;
        while (p != null && (p.getData() == value)) {            
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
}
