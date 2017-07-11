public class TestBox {
	Integer i=1;
	int j;
	public static void main (String[] args) {
		TestBox t = new TestBox();
		t.go();
	}
	public void go() {
		j=1;
		System.out.println(j);
		System.out.println(i);
	}
}