package com.mahesh;


/*
Author: Mahesh Punugupati
*/


import java.util.Random;
import java.util.Scanner;

public class Referee extends State implements Player {

    boolean coputerTurn;
    boolean playerTurn;
    Scanner sc = new Scanner(System.in);
    public static void main(String arg[]){
        Referee player = new Referee();
        player.initialise();
        player.printCurrentState();
        player.startGame();
    }

    public void startGame() {
        nextMove();
    }

    public void nextMove() {
        int position;
        if(coputerTurn==true){
            position = getPlayerYTurn();
            System.out.println("Player Y  selected "+position);
            if(position<0 || position>8){
                System.out.println("Position should be 0 to 8");
            }else if(fillBoxIndex(position, PlayerEnum.Y)){
                playerTurn = true;
                coputerTurn = false;
                checkWinner(PlayerEnum.Y);
                nextMove();
            }
        }
        else {
            position = getPlayerXTurn();
            System.out.println("Player X selected "+position);
            if(position<0 || position>8){
                System.out.println("Position should be 0 to 8");
            }else if(fillBoxIndex(position, PlayerEnum.X)){
                playerTurn = false;
                coputerTurn = true;
                checkWinner(PlayerEnum.X);
                nextMove();
            }
        }
        nextMove();
    }
}
