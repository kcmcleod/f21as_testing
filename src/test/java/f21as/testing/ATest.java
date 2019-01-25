package f21as.testing;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ATest {

    // Mocking is not necessary for the exam
    // We use the Mockito framework which provides a way of mocking (ie, using pretend) objects instead of real ones
    // We tell Mockito which objects to mock, and it will intercept all calls to the object and return whatever we
    // want it to. For an example see the 2nd method below

    // Below we test A using the techniques from before
    @Test
    public void testWithoutMocking() {
        B realB = new B();
        A objectToTest = new A();
        objectToTest.setB(realB);
        assertEquals("will be 0 if real B", 0, objectToTest.getB().getNumber());
    }

    // Problem is that we can't tell if A.setB() and A.getB() have worked without looking at B
    // So we must call B.getNumber() too
    // Therefore we cannot test A without also testing B
    // We want to test A as a unit, ie, in isolation
    //
    // Also what if we want to simulate B return strange results? Might be hard to do for real!
    // Hence mocking!

    @Test
    public void testWithMocking() {
        // fake, ie, mocked B
        B bMocked = mock(B.class);

        // define expectations - what we want the fake B to do
        // when fake getNumber() is called we want it to return 123
        // the real getNumber will return 0 (see above), but we can choose any int we want
        // we could also throw an exception if we want too!
        when(bMocked.getNumber()).thenReturn(123);

        // now do test
        A objectToTest = new A();
        objectToTest.setB(bMocked);
        assertEquals(123, objectToTest.getB().getNumber());
    }
}