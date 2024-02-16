package com.main;

public class Main {
    public static void main(String[] args) {
        MineGrid mineGrid = new MineGrid(10); 
        GameLogic gameLogic = new GameLogic(mineGrid); 

        System.out.println("::ADDRESSES::");
        mineGrid.printMineGridAddressGrid();
        System.out.println("::PLAYER GRID::");
        mineGrid.printMineGrid();
        //mineGrid.printMineGridMeta(); 
        
        boolean gameRunning = true;
        while (gameRunning) {
        	gameRunning = gameLogic.nextTurnHandler();
            
        }
        
    }
}