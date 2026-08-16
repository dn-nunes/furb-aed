import java.util.Objects;

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
            if (Objects.equals(data[i], value)) {
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

    public T getElement(int position) {
        if (position < 0 || position >= length) {
            throw new IndexOutOfBoundsException();
        }

        return (T) data[position];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getSize() {
        return length;
    }

    public void invert() {
        var left = 0;
        var right = length - 1;

        while (left < right) {
            var tempObj = data[right];
            data[right] = data[left];
            data[left] = tempObj;
            left++;
            right--;
        }
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
