package project.assignment1.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);
	}

	
	public
	void hurtCharacter(GameCharacter character) {
		if(!successfulDefense()) {
			setHealth(getHealth() - 50);
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
