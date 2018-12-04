package edu.wctc.jsadi.Test;

import edu.wctc.jsadi.StandardCheckout;
import org.junit.*;

public class StandardCheckoutTest extends junit.framework.TestCase {
    public StandardCheckoutTest() {}

    private StandardCheckout shortPark, normalPark, longPark;

    @Before
    public void setUp() throws Exception {
        shortPark = new StandardCheckout(1);
        normalPark = new StandardCheckout(5);
        longPark = new StandardCheckout(15);
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetCost() {
        assertEquals(shortPark.getCost(), 5.00);
        assertEquals(normalPark.getCost(), 7.00);
        assertEquals(longPark.getCost(), 15.00);
    }
}
