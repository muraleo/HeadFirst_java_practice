import java.util.*;

public class TestGenerics1{
	public static void main(String[] args){
		new TestGenerics1().start();
	}

	public void start(){
		Animal[] animals =  {new Dog(), new Cat(), new Dog()};
		Dog[] dogs = {new Dog(), new Dog(), new Dog()};
		takeAnimals(animals);
		takeAnimals(dogs);
	}

	public void takeAnimals(Animal[] animal){
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