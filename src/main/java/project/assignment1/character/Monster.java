package project.assignment1.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
		if(!character.successfulDefense()) {
			character.setHealth(character.getHealth() - 20);
		}
	}

	
	public boolean successfulDefense() {
		Random rand = new Random();
		
		int x = rand.nextInt(10);
		
		if(x%2 == 0) {
		  return true;
		}
		
		return false;
	}


	
	public String decideMove () {
		String[] move = {"up", "down", "left", "right"};
		Random rand = new Random();
		
		return move[rand.nextInt(4)];
	}

}
