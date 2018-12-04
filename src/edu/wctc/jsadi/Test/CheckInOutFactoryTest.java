package edu.wctc.jsadi.Test;

import edu.wctc.jsadi.CheckInOutFactory;
import edu.wctc.jsadi.CheckType;
import org.junit.*;

public class CheckInOutFactoryTest extends junit.framework.TestCase {
    public CheckInOutFactoryTest() {}

    private CheckInOutFactory testFac;

    @Before
    public void setUp() throws Exception {
        testFac = new CheckInOutFactory();
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetCheck() {
        assertNotSame(testFac.getCheck(CheckType.CHECKIN), testFac.getCheck(CheckType.CHECKOUT));
    }
}
