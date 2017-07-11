import java.util.*;
public class DotComBust{
	//declare and initialize the variable we need
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
	private int numberOfGuesses = 0;

	//declare and initialize SetUp Game method
	private void setUpGame(){
		DotCom one = new DotCom();
		one.setName("Lazy");

		DotCom two = new DotCom();
		two.setName("Lust");

		DotCom three = new DotCom();
		three.setName("Gluttony");

		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);

		System.out.println("Your goal is to sin three sins");
		System.out.println("They are: Lazy, Lust and Gluttony");
		System.out.println("Try to sink them all in the fewest number of guesses.");

		for(DotCom e:dotComList){
			e.setLocationCells(helper.placeDotCom(3));
		}
	}

	//declare start playing method
	private void startPlaying(){
		while(!dotComList.isEmpty()){
			checkUserGuess(helper.getUserInput("Enter a guess"));
		}
		finishGame();
	}

	//declare and initialize checkUserGuess method
	private void checkUserGuess(String userGuess){
		numberOfGuesses++;
		String result = "miss";

		for(DotCom e : dotComList){
			result = e.checkYourself(userGuess);
			if(result.equals("hit")){   //can result.equals() change to result = "hit"??
				break;
			}
			if(result.equals("kill")){
				dotComList.remove(e);
				break;
			}
		}
		System.out.println(result);
	}

	//declare and initialize finishGame method
	private void finishGame(){
		System.out.println("All sins are dead. You become a better person now");
		if(numberOfGuesses>18){
			System.out.println("Tough trip ha, you make "+numberOfGuesses+" guesses.");
		}
		else{
			System.out.println("You have a gift! you just make "+numberOfGuesses+" guesses.");
		}
	}

	public static void main(String[] args){
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}