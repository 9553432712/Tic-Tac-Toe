package com.mahesh;


/*
Author: Mahesh Punugupati
*/


import java.util.Scanner;

public class State {
    char box[][] = new char[3][3];
    Scanner sc = new Scanner(System.in);

    public void printCurrentState() {
        System.out.println();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(box[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void initialise() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                box[i][j]= '*';
            }
        }
    }
    public boolean fillBoxIndex(int position, PlayerEnum playerEnum){
        switch (position){
            case 0:
                if(box[0][0]!='*'){
                    System.out.println("Wrong selection");
                    return false;
                }
                if(playerEnum.toString().contains("X"))
                    box[0][0] = 'X';
                else
                    box[0][0] = 'Y';
                break;
            case 1:
                if(box[0][1]!='*'){
                    System.out.println("Wrong selection");
                    return false;
                }
                if(playerEnum.toString().contains("X"))
                    box[0][1] = 'X';
                else
                    box[0][1] = 'Y';
                break;
            case 2:
                if(box[0][2]!='*'){
                    System.out.println("Wrong selection");
                    return false;
                }
                if(playerEnum.toString().contains("X"))
                    box[0][2] = 'X';
                else
                    box[0][2] = 'Y';
                break;
            case 3:
                if(box[1][0]!='*'){
                    System.out.println("Wrong selection");
                    return false;
                }
                if(playerEnum.toString().contains("X"))
                    box[1][0] = 'X';
                else
                    box[1][0] = 'Y';
                break;
            case 4:
                if(box[1][1]!='*'){
                    System.out.println("Wrong selection");
                    return false;
                }
                if(playerEnum.toString().contains("X"))
                    box[1][1] = 'X';
                else
                    box[1][1] = 'Y';
                break;
            case 5:
                if(box[1][2]!='*'){
                    System.out.println("Wrong selection");
                    return false;
                }
                if(playerEnum.toString().contains("X"))
                    box[1][2] = 'X';
                else
                    box[1][2] = 'Y';
                break;
            case 6:
                if(box[2][0]!='*'){
                    System.out.println("Wrong selection");
                    return false;
                }
                if(playerEnum.toString().contains("X"))
                    box[2][0] = 'X';
                else
                    box[2][0] = 'Y';
                break;
            case 7:
                if(box[2][1]!='*'){
                    System.out.println("Wrong selection");
                    return false;
                }
                if(playerEnum.toString().contains("X"))
                    box[2][1] = 'X';
                else
                    box[2][1] = 'Y';
                break;
            case 8:
                if(box[2][2]!='*'){
                    System.out.println("Wrong selection");
                    return false;
                }
                if(playerEnum.toString().contains("X"))
                    box[2][2] = 'X';
                else
                    box[2][2] = 'Y';
                break;
            default:
                System.out.println("You enter wrong index");
                return false;
        }
        printCurrentState();
        return true;
    }
    public boolean checkWinner(PlayerEnum player){
        if(player.toString().contains("X")){
            if(rowCrossed('X') || columnCrossed('X') || diagonalCrossed('X')){
                System.out.println("Player X won");
                System.exit(0);
                return true;
            }
        }else {
            if(rowCrossed('Y') || columnCrossed('Y') || diagonalCrossed('Y')){
                System.out.println("Player Y/Computer won");
                System.exit(0);
                return true;
            }
        }
        if(checkGameOver()){
            System.out.println("Game is draw, Restart the game");
            System.exit(0);
            return true;
        }
        return false;
    }

    private boolean checkGameOver() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(box[i][j]=='*'){
                    return false;
                }
            }
        }
        return true;
    }

    boolean rowCrossed(char c)
    {
        for (int i=0; i<3; i++)
        {
            if (box[i][0] == box[i][1] &&
                    box[i][1] == box[i][2] &&
                    box[i][0] == c)
                return (true);
        }
        return(false);
    }

    boolean columnCrossed(char c)
    {
        for (int i=0; i<3; i++)
        {
            if (box[0][i] == box[1][i] &&
                    box[1][i] == box[2][i] &&
                    box[0][i] == c)
                return (true);
        }
        return(false);
    }

    boolean diagonalCrossed(char c)
    {
        if (box[0][0] == box[1][1] &&
                box[1][1] == box[2][2] &&
                box[0][0] == c)
            return(true);

        if (box[0][2] == box[1][1] &&
                box[1][1] == box[2][0] &&
                box[0][2] == c)
            return(true);

        return(false);
    }
    public int getPlayerYTurn(){
        int position=0;
        try {
            System.out.println("Player Y enter the state ");
            position = sc.nextInt();
            if(position<0 || position>8){
                throw new Move();
            }
        }catch (Exception e){
            System.out.println("Wrong input "+e);
        }
        return position;
    }

    public int getPlayerXTurn(){
        int position=0;
        try {
            System.out.println("Player X enter the state ");
            position = sc.nextInt();
            if(position<0 || position>8){
                throw new Move();
            }
        }
        catch (Exception e){
            System.out.println("Wrong input "+e);
        }
        return position;
    }
}
