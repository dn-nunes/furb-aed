public class StaticList<T> {
    private Object[] data;
    private int length;

    public StaticList() {
        data = new Object[10];
        length = 0;
    }

    private void resize() {
        var newVector = new Object[data.length + 10];

        for (int i = 0; i < length; i++) {
            newVector[i] = data[i];
        }

        data = newVector;
    }

    public void insert(T value) {
        if (length == data.length)
            resize();

        data[length] = value;
        length++;
    }

    public void show() {
        System.out.println("Elementos da lista:");
        for (int i = 0; i < length; i++) {
            System.out.println(data[i]);
        }
    }

    public int search(T value) {
        for (int i = 0; i < length; i++) {
            if (data[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public void remove(T value) {
        int position = search(value);
        if (position != -1) {
            for (int i = position; i < length - 1; i++) {
                data[i] = data[i + 1];
            }

            length--;
        }
    }

    public void clear() {
        data = new Object[10];
        length = 0;
    }

    public Object getElement(int position) {
        if (position < 0 || position >= length) {
            throw new IndexOutOfBoundsException();
        }

        return data[position];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getSize() {
        return length;
    }

    
    // public void invert() {
    //     var invertedList = new Object[data.length];
        
    //     int invertedListIndex = 0;
    //     for (int i = length; i != 0; i--) {
    //         invertedList[invertedListIndex] = data[length - 1];
    //         invertedListIndex++;
    //     }

    //     data = invertedList;
    // }
    
    public void invert() {
        for (int x = 0; x < length; x++) {            

            for (int i = length; i != 0; i--) {
                data[i] = data[i - 1];
            }

            data[x] = data[length];
        }

        data[length] = null;
    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (i > 0) {
                result.append(",");
            }

            result.append(data[i]);
        }

        return result.toString();
    }
}
