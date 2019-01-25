package f21as.testing;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BTest {

    // this rule is only used for "new_skool_exceptionTest()" below
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

    // TDD - Test Driven Development
    // Write all the tests before you write any code.
    // Write just enough code to make 1st test pass, then repeat iteratively
    //
    // Good at finding flaws in specification
    // Supposed to be efficient as you have fewer bug in code and problems with spec
    // BUT you spend a lot of time writing tests
    //
    // Works best with complex specs when doing agile

    @Test
    public void processNumber_smallNumber_boundary() {
        // SPEC: return "small number" if number < 10
        // want the boundary, ie the highest number that can be a "small number"
        b.setNumber(9);
        assertEquals("small number", b.processNumber());
    }

    @Test
    public void processNumber_mediumNumber_lowerBoundary() {
        // SPEC: return "medium number" if number < 100
        // want the lower boundary, ie the lowest number that can be a "medium number"
        b.setNumber(10);
        assertEquals("medium number", b.processNumber());
    }

    @Test
    public void processNumber_mediumNumber_upperBoundary() {
        // SPEC: return "medium number" if number < 100
        // want the upper boundary, ie the highest number that can be a "medium number"
        b.setNumber(99);
        assertEquals("medium number", b.processNumber());
    }

    @Test
    public void processNumber_largeNumber_boundary() {
        // SPEC: return "large number" if 100 < number
        // Problem! We don't know what 100 is... medium or large. Must change spec
        // SPEC 2: return "large number" if 100 <= number
        b.setNumber(100);
        assertEquals("large number", b.processNumber());
    }

    // With all the tests written we can now write the code in B

}