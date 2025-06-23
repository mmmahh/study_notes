package c03.s01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {
    @Test
    public void test() {
        BST<String, Integer> bst = new BST<>();
        bst.put("c", 3);
        bst.put("a", 1);
        bst.put("b", 2);
        bst.put("d", 4);

        bst.delete("c");
        System.out.println();
    }
}