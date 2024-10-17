package escuelaing.edu.BST;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class BSTTest {
    private BST<Integer> bst;

    @Before
    public void setUp() {
        bst = new BST<>();
    }

    @Test
    public void testAdd() {
        assertTrue(bst.add(5));
        assertTrue(bst.add(3));
        assertTrue(bst.add(7));
        assertEquals(3, bst.size());
    }

    @Test
    public void testContains() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(3));
        assertFalse(bst.contains(10));
    }

    @Test
    public void testRemoveLeafNode() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertEquals(2, bst.size());
        assertFalse(bst.contains(3));
    }

    @Test
    public void testRemoveNodeWithOneChild() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(6);
        assertEquals(3, bst.size());
        assertFalse(bst.contains(7));
    }

    @Test
    public void testRemoveNodeWithTwoChildren() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(6);
        bst.add(8);
        assertEquals(4, bst.size());
        assertFalse(bst.contains(7));
        assertTrue(bst.contains(6));
        assertTrue(bst.contains(8));
    }

    @Test
    public void testFindMin() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        assertEquals(Integer.valueOf(2), bst.findMin());
    }

    @Test
    public void testFindMax() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(8);
        bst.add(6);
        assertEquals(Integer.valueOf(8), bst.findMax());
    }

    @Test
    public void testInOrderTraversal() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.inOrderTraversal(); 

        String expectedOutput = "2 3 4 5 7 "; 
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testClear() {
        bst.add(5);
        bst.add(3);
        bst.clear();
        assertTrue(bst.isEmpty());
        assertEquals(0, bst.size());
    }
}
