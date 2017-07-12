import java.util.*;

public class TestMap{
	public static void main(String[] args){
		new TestMap().start();
	}

	public void start(){
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); //should use Integer not int!
		hm.put("Harry", 23);
		hm.put("Leo", 100);
		hm.put("Kakalote",2);

		System.out.println(hm);
		System.out.println(hm.get("Kakalote"));
	}
}