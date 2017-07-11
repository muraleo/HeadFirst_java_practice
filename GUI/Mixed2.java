class A {
	int ivar = 7;
	void m1() {
		System.out.print("A's m1,");
	}
	void m2() {
		System.out.print("A's m2, ");
	}
	void m3() {
		System.out.print("A's m3, ");
	}
}

class B extends A {
	void m1() {
		System.out.print("B’s m1, ");
	}
}

class C extends B{
	void m3(){
		System.out.println("C's m3, "+(ivar + 6));
	}
}

public class Mixed2{
	public static void main(String[] args){
		A a = new A();
		B b = new B();
		C c = new C();
		A a2 = new C();

		a2.m1();
		a2.m2();
		a2.m3();

		System.out.println();
	}
}
// //2
// abstract class Top{}
// class Tip extends Top{}

// //3
// abstract class Fee{}
// abstract class Fun extends Fee{}

// //4
// public interface Foo{}
// public class Bar implements Foo{}
// public class Baz extends Bar{}

// //5
// public interface Beta{}
// public interface Zeta{}
// public class Alpha extends Zeta{}
// public class Delta extends Alpha implments Beta{}