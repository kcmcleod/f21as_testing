package f21as.testing;

// Please look at B and BTest first
//
// A demonstrates composition and how to using mocking within testing
public class A {
	
	private B b;
	
	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
}
