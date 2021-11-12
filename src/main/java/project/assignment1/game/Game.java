package project.assignment1.game;

import project.assignment1.character.Monster;

public class Game {
    
	private Map m;
    
    Game (int height, int width) {
		m = new Map(height, width);
    }
    			
    public Map getMap() {
        return m;
    }
    
    public boolean nextRound (String input) {
		
		if(m.characters[0].getHealth() > 0) {
			GameLogic.moveCharacter(input, m, m.characters[0]);
		}
		
		for(int i = 1; i < m.characters.length; i++) {
			if(m.characters[i].getHealth() > 0) {
				GameLogic.moveCharacter(((Monster)m.characters[i]).decideMove(), m, m.characters[i]);
			}
		}
		
		if(m.characters[0].getHealth() <= 0) {
			System.out.println();
			System.out.println("YOU HAVE DIED!");
			return true;
		}
		else if(m.characters[1].getHealth() <= 0 && m.characters[2].getHealth() <= 0 && m.characters[3].getHealth() <= 0) {
			System.out.println();
			System.out.println("YOU HAVE WON!");
			return true;
		}
		
		return false;
    }
   
}