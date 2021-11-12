package project.assignment1.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);
	}

	
	public
	void hurtCharacter(GameCharacter character) {
		if(!character.successfulDefense()) {
			character.setHealth(character.getHealth() - 50);
			System.out.println("!!HIT!!" + sayName() + " successfully attacked " + character.sayName());
		}
		else {
			System.out.println("!!MISS!!" + character.sayName() + " successfully defended attack from " + sayName());
		}
	}

	
	public
	boolean successfulDefense() {
		Random rand = new Random();
		
		int x = rand.nextInt(10);
		
		if(x > 6) {
		  return true;
		}
		
		return false;
	}

}
