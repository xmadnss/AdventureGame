package project.assignment1.game;

import java.util.Scanner;

public class RunGame {

	private static boolean gameOver = false;

	public static void main(String[] args) {
		Game g = new Game(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		int round = 0;
		Scanner scan = new Scanner(System.in);
		String move = "";
		
		g.getMap().printLayout();
		
        while (!gameOver) {
			round++;
			System.out.println("Round " + round);
			
			move = scan.nextLine();
			
			GameLogic.moveCharacter(move, g.getMap(), g.getMap().characters[0]);
			
			if(g.getMap().characters[0].getHealth() == 0) {
				gameOver = true;
				System.out.println("YOU HAVE DIED!");
			}
			else if(g.getMap().characters[1].getHealth() == 0 && g.getMap().characters[2].getHealth() == 0 && g.getMap().characters[3].getHealth() == 0) {
				gameOver = true;
				System.out.println("YOU HAVE WON!");
			}

			g.getMap().printLayout();
		}
	}

}
