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
		System.out.println();
		
        while (!gameOver) {
			round++;
			System.out.println("Round " + round);
			System.out.println();
			
			move = scan.nextLine();
			
			if(g.nextRound(move)) {
				gameOver = true;
			}
			
			System.out.println();
			
			System.out.println("Health Player:  " + g.getMap().characters[0].getHealth());
			System.out.println("Health Monster1:  " + g.getMap().characters[1].getHealth());
			System.out.println("Health Monster2:  " + g.getMap().characters[2].getHealth());
			System.out.println("Health Monster3:  " + g.getMap().characters[3].getHealth());
			
			System.out.println();
			g.getMap().printLayout();
			System.out.println();
		}
	}

}
