package f21as.testing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BTest {

    private B b;

    @Before
    public void setUp() throws Exception {
        b = new B();
    }

    @Test
    public void getNumber() {
        // the message (1st parameter is optional)
        assertEquals("I expect this to return 0 because it is set to 0 when created", 0, b.getNumber());
    }
}