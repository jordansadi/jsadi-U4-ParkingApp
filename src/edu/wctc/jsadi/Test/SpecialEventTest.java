package edu.wctc.jsadi.Test;

import edu.wctc.jsadi.SpecialEvent;
import org.junit.*;

public class SpecialEventTest extends junit.framework.TestCase {
    public SpecialEventTest() {}

    private SpecialEvent se;

    @Before
    public void setUp() throws Exception {
        se = new SpecialEvent();
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetCost() {
        assertEquals(se.getCost(), 20.00);
        assertNotSame(se.getCost(), 20);
    }
}
