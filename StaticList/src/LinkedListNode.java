
public class LinkedListNode<T> {
    private T data;
    private LinkedListNode<T> next;

    public void setData(T value) { data = value; }
    public T getData() { return data; }
    public void setNext(LinkedListNode<T> node) { next = node; }
    public LinkedListNode<T> getNext() { return next;}

    public LinkedListNode() 
    { 
    }

    public LinkedListNode(T value) {
        data = value;
        next = null;
    }
}
