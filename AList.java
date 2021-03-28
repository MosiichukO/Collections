import java.util.ArrayList;
import java.util.Arrays;

public class AList implements Ilist {
    int capacity;
    int[] components;
    int[] temp;

    AList() {
        capacity = 10;
        components = new int[capacity];
    }

    AList(int capacity) {
        this.capacity = capacity;
    }

    AList(int[] array) {
        capacity = array.length;
        components = array;
    }

    @Override
    public void clear() {
        Arrays.fill(components, 0);
    }

    @Override
    public int size() {
        return components.length;
    }

    @Override
    public int get(int index) {
        return components[index];
    }

    @Override
    public boolean add(int value) {
        if (components[components.length - 1] == 0) {
            for (int i = 0; i < components.length; i++) {
                if (components[i] == 0) {
                    components[i] = value;
                    break;
                }
            }
        } else {
            temp = components;
            components = new int[temp.length];
            System.arraycopy(temp, 0, components, 0, temp.length);
        }
        return true;
    }


    @Override
    public boolean add(int index, int value) {
        if (components[index] == 0) {
            components[index] = value;
        } else {
            temp = components;
            components = new int[temp.length + 1];
            System.arraycopy(temp, 0, components, 0, index);
            components[index] = value;
            int rightPartAfterIndex = temp.length - index;
            System.arraycopy(temp, index, components, index + 1, rightPartAfterIndex);
        }
        return true;
    }


    @Override
    public int remove(int number) {
        int index;
        temp = components;
        for (int i = 0; i < components.length; i++) {
            if (components[i] == number) {
                index = i;
                System.arraycopy(temp, index + 1, components, index, temp.length - index - 1);
            }
        }
        components[components.length - 1] = 0;
        return number;
    }

    @Override
    public int removeByIndex(int index) {
        temp = components;
        System.arraycopy(temp, index + 1, components, index, temp.length - index - 1);
        components[components.length - 1] = 0;
        return 0;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i <= components.length - 1; i++) {
            if (components[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, int value) {
        components[index] = value;
        return true;
    }

    @Override
    public void print() {
        temp = components;
        components = new int[temp.length];
        System.arraycopy(temp, 0, components, 0, temp.length);
        System.out.println(Arrays.toString(components));
    }

    @Override
    public int[] toArray() {
        return components;
    }

    @Override
    public boolean removeAll(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < components.length; j++) {
                if (ar[i] == components[j]) {
                    components[j] = 0;
                }
            }
        }
        return true;
    }
}
