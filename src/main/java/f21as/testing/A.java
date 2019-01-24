package f21as.testing;

// Please look at B and BTest first
//
// A demonstrates composition and how to using mocking within testing
public class A {
	
	private B b; // composition = B is part of A, e.g., the heart is part of the human

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
}
