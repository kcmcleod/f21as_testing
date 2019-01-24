package f21as.testing;

// Please look at B and BTest first
//
// A demonstrates composition and how to using mocking within testing
public class A {
	
	private B b; // composition = A has a B, e.g., Dog has a collar

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
}
