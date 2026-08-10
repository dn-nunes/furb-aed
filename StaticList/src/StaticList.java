public class StaticList {
    private int[] data;
    private int length;

    public StaticList() {
        data = new int[10];
        length = 0;
    }

    private void resize() {
        var newVector = new int[data.length + 10];

        for (int i = 0; i < length; i++) {
            newVector[i] = data[i];
        }

        data = newVector;
    }

    public void insert(int value) {
        if (length == data.length)
            resize();

        data[length] = value;
        length++;
    }

    public void show() {
        System.out.println("Números da lista:");
        for (int i = 0; i < length; i++) {
            System.out.println(data[i]);
        }
    }

    public int search(int value) {
        for (int i = 0; i < length; i++) {
            if (data[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public void remove(int value) {
        int position = search(value);
        if (position != -1) {
            for (int i = position; i < length - 1; i++) {
                data[i] = data[i + 1];
            }

            length--;
        }
    }

    public void clear() {
        data = new int[10];
        length = 0;
    }

    public int getElement(int position) {
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
