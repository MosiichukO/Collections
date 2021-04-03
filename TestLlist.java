package MyLlist;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestLlist {
    LList lList = new LList();

    @Before
    public void before() {
        lList.add(2);
        lList.add(5);
        lList.add(8);
        lList.add(10);
        lList.add(15);
    }

    @Test
    public void test_add_value() {
        int[] expected = {2, 5, 8, 10, 15};
        int[] actual = lList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_clear() {
        lList.clear();
        int[] expected = {};
        int[] actual = lList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_add_valueAndIndex() {
        lList.add(3, 100);
        int[] expected = {2, 5, 8, 100, 10, 15};
        int[] actual = lList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_size() {
        int expected = 5;
        int actual = lList.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_get() {
        int expected = 10;
        int actual = lList.get(3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_remove() {
        lList.remove(8);
        int[] expected = {2, 5, 10, 15};
        int[] actual = lList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_removeByIndex() {
        lList.removeByIndex(2);
        int[] expected = {2, 5, 10, 15};
        int[] actual = lList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_contains () {
        boolean expected = lList.contains(10);
        Assertions.assertTrue(expected);
    }

    @Test
    public void test_set () {
        lList.set(2, 125);
        int[] expected = {2, 5, 125, 10, 15};
        int[] actual = lList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_print () {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        lList.print();
        Assertions.assertEquals("2 5 8 10 15", output.toString().trim());
        System.setOut(null);
    }

    @Test
    public void test_toArray () {
        int[] expected = {2, 5, 8, 10, 15};
        int[] actual = lList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_removeAll () {
        int[] ar = new int[]{5, 10};
        lList.removeAll(ar);
        int[] expected = {2, 8, 15};
        int[] actual = lList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }
}
