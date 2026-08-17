
public class LinkedListNode {
    private int data;
    private LinkedListNode next;

    public void setData(int value) { data = value; }
    public int getData() { return data; }
    public void setNext(LinkedListNode node) { next = node; }
    public LinkedListNode getNext() { return next; }

    public LinkedListNode() 
    { 
    }

    public LinkedListNode(int value) {
        data = value;
        next = null;
    }
}
