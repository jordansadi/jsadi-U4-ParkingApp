package edu.wctc.jsadi.Test;

import edu.wctc.jsadi.RandomTime;
import org.junit.*;

public class RandomTimeTest extends junit.framework.TestCase {
    public RandomTimeTest() {}

    private RandomTime randIn, randOut, rt;

    @Before
    public void setUp() throws Exception {
        rt = new RandomTime("");
        randIn = new RandomTime("in");
        randOut = new RandomTime("out");
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetTime() {
        assertNotSame(rt.getTime(), randIn.getTime());
        assertNotSame(rt.getTime(), randOut.getTime());
        assertNotSame(randIn.getTime(), randOut.getTime());
    }

    @Test
    public void testGetHour() {
        assertNotSame(rt.getHour(), randIn.getHour());
        assertNotSame(rt.getHour(), randOut.getHour());
        assertNotSame(randIn.getHour(), randOut.getHour());
    }
}
