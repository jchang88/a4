/**
 * @author Jeffrey Chang jchang88, Allan Wang awang53
 * 600.226.02
 * Assignment a4
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;

public class QueueTest {

    // Initialize max priority queue heap
    MaxPQHeap<Integer> mpQueue;
 
    // Create new max priority queue heap for each test
    @Before
    public void setUp() {
        mpQueue = new MaxPQHeap<Integer>();
    }

    // Test size after inserting values and clearing
    @Test
    public void testSize() {
        assertEquals(0, mpQueue.size());
        mpQueue.insert(1);
        assertEquals(1, mpQueue.size());
        mpQueue.insert(69);
        assertEquals(2, mpQueue.size());
        mpQueue.insert(42);
        assertEquals(3, mpQueue.size());
        mpQueue.insert(7);
        assertEquals(4, mpQueue.size());
        mpQueue.insert(69);
        assertEquals(5, mpQueue.size());
        mpQueue.clear();
        assertEquals(0, mpQueue.size());
    }

    // Test if isEmpty returns correct boolean
    @Test
    public void testEmpty() {
        assertTrue(mpQueue.isEmpty());
        mpQueue.insert(1);
        assertFalse(mpQueue.isEmpty());
        mpQueue.insert(69);
        assertFalse(mpQueue.isEmpty());
        mpQueue.insert(42);
        assertFalse(mpQueue.isEmpty());
        mpQueue.insert(7);
        assertFalse(mpQueue.isEmpty());
        mpQueue.insert(69);
        assertFalse(mpQueue.isEmpty());
        mpQueue.clear();
        assertTrue(mpQueue.isEmpty());
    }

    // Test clear on an empty heap
    @Test
    public void testClearEmptyHeap() {
        mpQueue.clear();
        assertTrue(mpQueue.isEmpty());
    }

    // Test getMax and removeMax
    @Test
    public void testMax() {
        mpQueue.insert(1);
        mpQueue.insert(69);
        mpQueue.insert(42);
        mpQueue.insert(7);
        mpQueue.insert(69);
        assertEquals(69, mpQueue.getMax());
        assertEquals(mpQueue.getMax(), mpQueue.removeMax());
        assertEquals(69, mpQueue.removeMax());
        assertEquals(42, mpQueue.getMax());
        mpQueue.insert(100);
        assertEquals(100, mpQueue.getMax());
        mpQueue.clear();
    }

    // Test getMax on an empty heap
    @Test (expected = QueueEmptyException.class)
    public void testEmptyGetMax() {
        mpQueue.getMax();
    }

    // Test removeMax on empty heap
    @Test (expected = QueueEmptyException.class)
    public void testEmptyRemMax() {
        mpQueue.removeMax();
    }

    // Test insert and check size after each insert
    @Test
    public void testInsert() {
        for (int i = 1; i <= 50; i++) {
            mpQueue.insert(i);
            assertEquals(i, mpQueue.size());
        }
    }

    // Test init with an array list from 1 to 50
    @Test
    public void testInit() {
        ArrayList<Integer> list = new ArrayList<Integer>();
         for (int i = 1; i <= 50; i++) {
            list.add(i);
        }
        mpQueue.init(list);
        assertEquals(50, mpQueue.size());
        assertEquals(50, mpQueue.getMax());
    }

    // Test init with an empty array list
    @Test
    public void testInitEmpty() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        mpQueue.init(list);
        assertTrue(mpQueue.isEmpty());
        assertEquals(0, mpQueue.size());
    }


}
