//TreeSet exercise code using implements Comparable interface

import java.util.*;

public class TreeTest1{
	public static void main(String[] args){
		TreeTest1 tt1 = new TreeTest1();
		tt1.start();
	}	

	public void start(){
		Book b1 = new Book("How cats work");
		Book b2 = new Book("Harry Potter");
		Book b3 = new Book("Finding Emo");

		TreeSet<Book> tb = new TreeSet<Book>();
		tb.add(b1);
		tb.add(b2);
		tb.add(b3);

		System.out.println(tb);
	}
}

class Book implements Comparable{
	String title;
	public Book(String t){
		title = t;
	}
	public int compareTo(Object b){
		Book bk = (Book) b;
		return (title.compareTo(bk.title));
	}

	public String toString(){
		return title;
	}
}