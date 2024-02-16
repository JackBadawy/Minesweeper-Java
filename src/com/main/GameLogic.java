package com.main;

import java.util.Scanner;

public class GameLogic {
    private MineGrid mineGrid;
    private Scanner playerTurn; 

    public GameLogic(MineGrid mineGrid) {
        this.mineGrid = mineGrid;
        this.playerTurn = new Scanner(System.in); 
    }
    
    public boolean nextTurnHandler() {
        System.out.print("Enter tile address: ");
        String userInput = playerTurn.nextLine();
        boolean validSelection = mineGrid.selectTile(userInput);
        if (!validSelection) {
            System.out.println();
            return false; 
        }
        if (mineGrid.checkWin()) {
            System.out.println("Congratulations! You have successfully cleared all non-mine cells!");
            return false; 
        }
        return true;
    }

    
    public void endGame() {
        playerTurn.close(); 
    }
}


