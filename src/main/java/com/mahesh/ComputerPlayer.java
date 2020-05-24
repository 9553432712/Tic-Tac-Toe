package com.mahesh;


/*
Author: Mahesh Punugupati
*/


import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer extends State implements Player {
    boolean coputerTurn;
    boolean playerTurn;

    public static void main(String arg[]){
        ComputerPlayer player = new ComputerPlayer();
        player.initialise();
        player.printCurrentState();
        player.startGame();
    }


    public void startGame() {
        nextMove();
    }

    public void nextMove() {
        int position;
        //First chance given to Player X
        if(coputerTurn==true){
            position = getComputerTurn();
            System.out.println("Computer(Player Y) selected "+position);
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
    public int getComputerTurn(){
        Random r = new Random();
        return r.nextInt(9);
    }
}
