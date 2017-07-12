import java.util.*;

public class TestGenerics3{
	public static void main(String[] args){
		new TestGenerics3().start();
	}

	public void start(){
		ArrayList<Dog> animals = new ArrayList<Dog>();
		animals.add(new Dog());
		animals.add(new Dog());
		animals.add(new Dog());
		takeAnimals(animals); //put in Animals, works well
	}

	//will not work when input type is Dog
	//just imagine there is one sentence in takeAnimals
	// public void takeAnimals(ArrayList<Animal> animal){
	// 	animal.add(new Cat());
	// 	}
	// }
	//will ruin all thing
	public void takeAnimals(ArrayList<Animal> animal){
		for(Animal a:animal){
			a.eat();
		}
	}
}

abstract class Animal{
	void eat(){
		System.out.println("Animal is eating");
	}
}

class Dog extends Animal{
	void bark(){
		System.out.println("Bark! Bark! Bark!");
	}
}

class Cat extends Animal{
	void meow(){
		System.out.println("Meow, Meow, Meow");
	}
}