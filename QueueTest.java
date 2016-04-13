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

public class QueueTest {

    @Before
    public void setUp() {
        MaxPriorityQueue<Integer> mpQueue = MaxPriorityQueue<Integer>();
    }

    @Test
    public void testSize() {
        assertEquals(0, mpQueue.size());
        mpQueue.insert(1);
        mpQueue.insert(69);
        mpQueue.insert(42);
        mpQueue.insert(7);
        mpQueue.insert(69);
        assertEquals(5, mpQueue.size());
        mpQueue.clear();
        assertEquals(0, mpQueue.size());
    }

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

    @Test (expected = QueueEmptyException.class)
    public void testEmptyGetMax() {
        mpQueue.getMax();
    }

    @Test (expected = QueueEmptyException.class)
    public void testEmptyRemMax() {
        mpQueue.removeMax();
    }

    @Test
    public void testInsert() {
        for (int i = 1; i <= 50; i++) {
            mpQueue.insert(i);
            assertEquals(i, mpQueue.size());
        }
    }

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

}
