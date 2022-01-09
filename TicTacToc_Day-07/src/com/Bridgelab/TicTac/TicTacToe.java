package com.Bridgelab.TicTac;


import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static char[] boardArray= new char[10];
    private static char player1Choice;
    private static char player2Choice;
    
    static Scanner scan= new Scanner(System.in);
    
    //UC1 Initialize Board
    public static void initBoard() {
    	for (int i=1;i<10;i++)
    	{
    		boardArray[i]=' ';
    		
    	}
    }
    
    //UC2 Get User Input
    public static void playerchoice()
    {
    	System.out.println("enter player 1 choice (X /O):");
    	char choice=scan.next().toUpperCase().charAt(0);
    	if(choice == 'X') {
    		player1Choice = choice;
    		player2Choice ='O';
    	}else if(choice =='O') {
    		player1Choice = choice;
    		player2Choice ='X';
    	}else {
    		System.out.println("Wrong Choice Entered.");
    		playerchoice();
    	}
    	}
    //UC3 show board
    public static void showboard() {
    	System.out.println("-----------");
    	System.out.println("|"+boardArray[1]+"|"+boardArray[2]+"|"+boardArray[3]+"|");
    	System.out.println("|"+boardArray[4]+"|"+boardArray[5]+"|"+boardArray[6]+"|");
    	System.out.println("|"+boardArray[7]+"|"+boardArray[8]+"|"+boardArray[9]+"|");
    	
    }
    //UC 4 User Input
    private static void getUserInput(int i) {
    	System.out.println("player"+i+"Enter the position for your symbol: ");
    	int position = scan .nextInt();
    	if(i==1) {
    		boardArray[position]=player1Choice;
    	} else {
    		boardArray[position]=player2Choice;	
    	}
    }
    //UC 5
    private static int flipTose() {
    	Random toss = new Random();
    	int tossValue = toss.nextInt(2)+1;
    	return tossValue;
    }
    //UC 6
    private static void  gamePlay(int tossValue) {
    	for (int i=1;i<10;i++) {
    		if(i%2==0) {
    			if(tossValue==2) {
    				getUserInput(1);
    			}else {
    				getUserInput(2);
    			}
    			}else {
    				getUserInput(tossValue);
    		}
    		showboard();
    	}
    }
public static void main(String[] args) {
	initBoard();
	playerchoice();
	showboard();
    int tossValue = flipTose();
    gamePlay(tossValue);

} 

}




