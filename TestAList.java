
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestAList {


    @Test
    public void test_clear() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        AList aList = new AList(array);

        aList.clear();

        int[] actual = aList.toArray();
        int[] expected = {0, 0, 0, 0, 0, 0};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_size() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        AList aList = new AList(array);

        int actual = aList.size();
        int expected = 6;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_get() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        AList aList = new AList(array);

        int actual = aList.get(4);
        int expected = 5;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_addValue() {
        AList aList = new AList();
        aList.add(5);
        aList.add(10);

        int[] actual = aList.toArray();
        int[] expected = {5, 10, 0, 0, 0, 0, 0, 0, 0, 0};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_addValueIndex() {
        AList aList = new AList();
        aList.add(3, 33);
        aList.add(6, 66);

        int[] actual = aList.toArray();
        int[] expected = {0, 0, 0, 33, 0, 0, 66, 0, 0, 0};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_remove() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        AList aList = new AList(array);

        aList.remove(3);


        int[] actual = aList.toArray();
        int[] expected = {1, 2, 4, 5, 6, 0};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_removeByIndex() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        AList aList = new AList(array);

        aList.removeByIndex(2);

        int[] actual = aList.toArray();
        int[] expected = {1, 2, 4, 5, 6, 0};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_contains_true() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        AList aList = new AList(array);

        boolean actual = aList.contains(5);

        Assertions.assertTrue(actual);
    }

    @Test
    public void test_contains_false() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        AList aList = new AList(array);

        boolean actual = aList.contains(8);

        Assertions.assertFalse(actual);
    }

    @Test
    public void test_set() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        AList aList = new AList(array);

        aList.set(4, 100);

        int[] actual = aList.toArray();
        int[] expected = {1, 2, 3, 4, 100, 6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_print() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        AList aList = new AList(array);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        aList.print();
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6]", output.toString().trim());
        System.setOut(null);
    }

    @Test
    public void test_toArray() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        AList aList = new AList(array);

        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] actual = aList.toArray();

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test_removeAll() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        AList aList = new AList(array);

        int[] arr = new int[]{2, 6};
        aList.removeAll(arr);

        int[] expected = {1, 0, 3, 4, 5, 0};
        int[] actual = aList.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }
}
