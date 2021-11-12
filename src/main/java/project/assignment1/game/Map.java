package project.assignment1.game;

import project.assignment1.character.GameCharacter;
import project.assignment1.character.Monster;
import project.assignment1.character.Player;

public class Map {

public String [][] layout;
public GameCharacter characters [] = new GameCharacter [4];
 
  Map (int height, int width) {
	 layout = new String[height][width];
	 initialiseArray();
  }
  
  private void initialiseArray() {
	  Player p = new Player("Player");
	  Monster m1 = new Monster("Monster1");
	  Monster m2 = new Monster("Monster2");
	  Monster m3 = new Monster("Monster3");
	  
	  //bottom right
	  p.row = layout.length - 1;
	  p.column = layout[0].length - 1;
	  
	  //top right
	  m1.row = 0;
	  m1.column = layout[0].length - 1;
	  
	  //bottom left
	  m2.row = layout.length - 1;
	  m2.column = 0;
	  
	  //top left
	  m3.row = 0;
	  m3.column = 0;
	  
	  characters[0] = p;
	  characters[1] = m1;
	  characters[2] = m2;
	  characters[3] = m3;
	  
	  for(int h = 0; h < layout.length; h++) {
		  for(int w = 0; w < layout[h].length; w++) {
			  if(h == 0 && w == 0) {
				  layout[h][w] = "%";
			  }
			  else if(h == 0 && w == layout[0].length - 1) {
				  layout[h][w] = "%";
			  }
			  else if(h == layout.length - 1 && w == 0) {
				  layout[h][w] = "%";
			  }
			  else if(h == layout.length - 1 && w == layout[h].length - 1) {
				  layout[h][w] = "*";
			  }
			  else {
				layout[h][w] = ".";
			  }
		  }
	  }
  }
 
  public void printLayout() {
	for(int h = 0; h < layout.length; h++) {
		  for(int w = 0; w < layout[h].length; w++) {
			  System.out.print(layout[h][w]);
		  }
		  System.out.println();
	  }
   }
}
