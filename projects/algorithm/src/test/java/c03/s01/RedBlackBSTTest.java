package c03.s01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RedBlackBSTTest {

    @Test
    public void testRedBlackBST() {
        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("E", "e");
        redBlackBST.put("A", "a");
        redBlackBST.put("B", "b");

        System.out.println();
    }

}