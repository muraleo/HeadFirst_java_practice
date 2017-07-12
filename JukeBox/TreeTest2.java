//TreeSet exercise code using TreeSet's overloaded constructor
//which takes comparator

import java.util.*;

public class TreeTest2{
	public static void main(String[] args){
		//short way to write main function
		new TreeTest2().start();
	}	

	class BookCompare implements Comparator<Book>{
		public int compare(Book one, Book two){
			return one.title.compareTo(two.title);
		}
	}

	public void start(){
		Book b1 = new Book("How cats work");
		Book b2 = new Book("Harry Potter");
		Book b3 = new Book("Finding Emo");

		BookCompare bc = new BookCompare();
		TreeSet<Book> tb = new TreeSet<Book>(bc);
		tb.add(b1);
		tb.add(b2);
		tb.add(b3);

		System.out.println(tb);
	}
}

class Book{
	String title;
	public Book(String t){
		title = t;
	}

	public String toString(){
		return title;
	}
}