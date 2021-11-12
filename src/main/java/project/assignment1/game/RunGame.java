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
			
			if(g.nextRound(move)) {
				gameOver = true;
			}

			g.getMap().printLayout();
		}
	}

}
