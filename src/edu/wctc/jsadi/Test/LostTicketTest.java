package edu.wctc.jsadi.Test;

import edu.wctc.jsadi.LostTicket;
import org.junit.*;

public class LostTicketTest extends junit.framework.TestCase {
    public LostTicketTest() {}

    private LostTicket lt;

    @Before
    public void setUp() throws Exception {
        lt = new LostTicket();
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetCost() {
        assertEquals(lt.getCost(), 25.00);
        assertNotSame(lt.getCost(), 25);
    }
}
