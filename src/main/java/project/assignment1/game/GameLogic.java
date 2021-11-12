package project.assignment1.game;

import java.util.Scanner;

import project.assignment1.character.GameCharacter;
import project.assignment1.character.Player;
import project.assignment1.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		if(!input.equals("up") && !input.equals("down") && !input.equals("left") && !input.equals("right")) {
			System.out.println("Use only keywords up, down, left, right");
		}
		else if(character.getHealth() > 0) {
			if(input.equals("up")) {
				moveUp(character, gameMap);
			}
			else if(input.equals("down")) {
				moveDown(character, gameMap);
			}
			else if(input.equals("left")) {
				moveLeft(character, gameMap);
			}
			else if(input.equals("right")) {
				moveRight(character, gameMap);
			}
		}
	}
	
	private static void moveRight(GameCharacter character, Map gameMap) {
		int r = character.row;
		int c = character.column;
		
		System.out.println(character.sayName() + " is moving right");
		
		if(c == gameMap.layout[0].length - 1) {
			System.out.println("You can't go right. You lose a move");
		}
		else if(gameMap.layout[r][c + 1].equals("x")) {
			if(gameMap.layout[r][c].equals("%")) {
				System.out.println("Monster already there so can't move");
			}
			else {	
				System.out.println("Character already dead");
			}
		}
		else if(gameMap.layout[r][c + 1].equals("%")) {
			if(gameMap.layout[r][c].equals("%")) {
				System.out.println("Monster already there so can't move");
			}
			else {	
				for(int i = 1; i < gameMap.characters.length; i++) {
					if(gameMap.characters[i].row == r && gameMap.characters[i].column == c + 1) {
						character.hurtCharacter(gameMap.characters[i]);
						if(gameMap.characters[i].getHealth() <= 0) {
							gameMap.layout[r][c + 1] = "x";
						}
					}
				}
			}
		}
		else if(gameMap.layout[r][c + 1].equals("*")) {
			character.hurtCharacter(gameMap.characters[0]);
		}
		else {
			if(gameMap.layout[r][c].equals("%")) {
				gameMap.layout[r][c + 1] = "%";
			}
			else {	
				gameMap.layout[r][c + 1] = "*";
			}
			
			gameMap.layout[r][c] = ".";
			character.column++;
		}
	}
	
	private static void moveLeft(GameCharacter character, Map gameMap) {
		int r = character.row;
		int c = character.column;
		
		System.out.println(character.sayName() + " is moving left");
		
		if(c == 0) {
			System.out.println("You can't go left. You lose a move");
		}
		else if(gameMap.layout[r][c - 1].equals("x")) {
			if(gameMap.layout[r][c].equals("%")) {
				System.out.println("Monster already there so can't move");
			}
			else {	
				System.out.println("Character already dead");
			}
		}
		else if(gameMap.layout[r][c - 1].equals("%")) {
			if(gameMap.layout[r][c].equals("%")) {
				System.out.println("Monster already there so can't move");
			}
			else {	
				for(int i = 1; i < gameMap.characters.length; i++) {
					if(gameMap.characters[i].row == r && gameMap.characters[i].column == c - 1) {
						character.hurtCharacter(gameMap.characters[i]);
						if(gameMap.characters[i].getHealth() <= 0) {
							gameMap.layout[r][c - 1] = "x";
						}
					}
				}
			}
		}
		else if(gameMap.layout[r][c - 1].equals("*")) {
			character.hurtCharacter(gameMap.characters[0]);
		}
		else {
			if(gameMap.layout[r][c].equals("%")) {
				gameMap.layout[r][c - 1] = "%";
			}
			else {	
				gameMap.layout[r][c - 1] = "*";
			}
			
			gameMap.layout[r][c] = ".";
			character.column--;
		}
	}
	
	private static void moveUp(GameCharacter character, Map gameMap) {
		int r = character.row;
		int c = character.column;
		
		System.out.println(character.sayName() + " is moving up");
		
		if(r == 0) {
			System.out.println("You can't go up. You lose a move");
		}
		else if(gameMap.layout[r - 1][c].equals("x")) {
			if(gameMap.layout[r][c].equals("%")) {
				System.out.println("Monster already there so can't move");
			}
			else {	
				System.out.println("Character already dead");
			}
		}
		else if(gameMap.layout[r - 1][c].equals("%")) {
			if(gameMap.layout[r][c].equals("%")) {
				System.out.println("Monster already there so can't move");
			}
			else {	
				for(int i = 1; i < gameMap.characters.length; i++) {
					if(gameMap.characters[i].row == r - 1 && gameMap.characters[i].column == c) {
						character.hurtCharacter(gameMap.characters[i]);
						if(gameMap.characters[i].getHealth() <= 0) {
							gameMap.layout[r - 1][c] = "x";
						}
					}
				}
			}
		}
		else if(gameMap.layout[r - 1][c].equals("*")) {
			character.hurtCharacter(gameMap.characters[0]);
		}
		else {
			if(gameMap.layout[r][c].equals("%")) {
				gameMap.layout[r - 1][c] = "%";
			}
			else {	
				gameMap.layout[r - 1][c] = "*";
			}
			
			gameMap.layout[r][c] = ".";
			character.row--;
		}
	}
	
	private static void moveDown(GameCharacter character, Map gameMap) {
		int r = character.row;
		int c = character.column;
		
		System.out.println(character.sayName() + " is moving down");
		
		if(r == gameMap.layout.length - 1) {
			System.out.println("You can't go down. You lose a move");
		}
		else if(gameMap.layout[r + 1][c].equals("x")) {
			if(gameMap.layout[r][c].equals("%")) {
				System.out.println("Monster already there so can't move");
			}
			else {	
				System.out.println("Character already dead");
			}
		}
		else if(gameMap.layout[r + 1][c].equals("%")) {
			if(gameMap.layout[r][c].equals("%")) {
				System.out.println("Monster already there so can't move");
			}
			else {	
				for(int i = 1; i < gameMap.characters.length; i++) {
					if(gameMap.characters[i].row == r + 1 && gameMap.characters[i].column == c) {
						character.hurtCharacter(gameMap.characters[i]);
						if(gameMap.characters[i].getHealth() <= 0) {
							gameMap.layout[r + 1][c] = "x";
						}
					}
				}
			}
		}
		else if(gameMap.layout[r + 1][c].equals("*")) {
			character.hurtCharacter(gameMap.characters[0]);
		}
		else {
			if(gameMap.layout[r][c].equals("%")) {
				gameMap.layout[r + 1][c] = "%";
			}
			else {	
				gameMap.layout[r + 1][c] = "*";
			}
			
			gameMap.layout[r][c] = ".";
			character.row++;
		}
	}
	
}
