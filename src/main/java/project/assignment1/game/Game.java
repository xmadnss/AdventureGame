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
        return true;
    }
   
}