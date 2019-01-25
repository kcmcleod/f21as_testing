package f21as.testing;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BTest {

    // this rule is only used for "new_skool_exceptionTest()" below
    @Rule
    ExpectedException thrown = ExpectedException.none();

    private B b;

    // method will be called before EVERY test.
    // ensures we have a new B for every test
    @Before
    public void setUp() throws Exception {
        b = new B();
    }

    @Test
    public void getNumber() {
        // the message (1st parameter is optional)
        assertEquals("I expect this to return 0 because it is set to 0 when created", 0, b.getNumber());
    }

    @Test
    public void setNumber_pass() {
        // testing min boundary
        b.setNumber(0);
        assertEquals(0, b.getNumber());

        b.setNumber(6+6);
        assertEquals(12, b.getNumber());
    }

    // easiest way to test for exceptions
    @Test(expected = IllegalArgumentException.class)
    public void setNumber_lessThan0_fail() {
        // testing min boundary - 1
        b.setNumber(-1);
    }

    @Test
    public void old_skool_exceptionTest() {
        try {
            b.setNumber(-1);
            fail(); // line ensures test fails if no exception thrown by above line
        } catch(IllegalArgumentException e) {
            // test message
            assertEquals("Value of number must be 0 or more", e.getMessage());
        }
    }


    @Test
    public void new_skool_exceptionTest() {
        // define thrown at top of Tests
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Value of number must be 0 or more");
        b.setNumber(-1);
    }
}