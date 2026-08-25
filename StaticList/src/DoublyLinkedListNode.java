
public class DoublyLinkedListNode<T> {
    private T data;
    private DoublyLinkedListNode<T> before;
    private DoublyLinkedListNode<T> next;

    public void setData(T value) { data = value; }
    public T getData() { return data; }
    public void setBefore(DoublyLinkedListNode<T> node) { before = node; }
    public DoublyLinkedListNode<T> getBefore() { return before; }
    public void setNext(DoublyLinkedListNode<T> node) { next = node; }
    public DoublyLinkedListNode<T> getNext() { return next; }

    public DoublyLinkedListNode() 
    { 
    }

    public DoublyLinkedListNode(T value) {
        data = value;
    }
}
