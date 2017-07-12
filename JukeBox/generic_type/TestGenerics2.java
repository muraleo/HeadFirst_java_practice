import java.util.*;

public class TestGenerics2{
	public static void main(String[] args){
		new TestGenerics2().start();
	}

	public void start(){
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog());
		animals.add(new Dog());
		animals.add(new Dog());
		takeAnimals(animals); //put in Animals, works well
	}

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