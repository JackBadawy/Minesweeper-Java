package com.main;

public class MineGrid {
	private Cell[][] grid;
	private int totalMines;
	
public MineGrid(int size) {
	
	
	grid = new Cell[size][size];
	
	
    
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          String gridAddress = generateGridAddress(i,j);
            grid[i][j] = new Cell(0, '*', false, false, gridAddress); 
        }
    }
    
    int minesPlaced = 0;
	while (minesPlaced < size) {
    	int i = (int) (Math.random() * size);
    	int j = (int) (Math.random() * size);
    	if (!grid[i][j].isMine()) {
    		grid[i][j].setMine(true); 
    		for (int ii = -1; ii <= 1; ii++) {
    			for (int jj = -1; jj <= 1; jj++) {
    				int newI = i + ii;
    				int newJ = j + jj;
    				if (newI >= 0 && newI < size && newJ >= 0 && newJ < size && (ii != 0 || jj != 0)) {
    					int currentMines = grid[newI][newJ].getBorderingMines();
    					grid[newI][newJ].setBorderingMines(currentMines + 1);
    					totalMines++;
    				}
    			}
    		}
    		minesPlaced++;
    	}
    }
	minesPlaced = 0; 
} 

public boolean checkWin() {
    int revealedCells = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            Cell cell = grid[i][j];
            if (!cell.isMine() && cell.getHasBeenClicked()) {
                revealedCells++;
            }
        }
    }
    int totalNonMineCells = 100 - 10;
   // System.out.println("Revealed cells:" + revealedCells);
  //  System.out.println("Total non mine cells:" + totalNonMineCells);
    return revealedCells == totalNonMineCells;
}

private String generateGridAddress(int indexOne, int indexTwo) {
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    int addressNum = indexTwo + 1; 
    if (indexOne > 25 || indexOne < 0) {
        return null;
    }
    return Character.toString(alphabet[indexOne]) + addressNum;
}

public void printMineGridMeta() { //i used this for debugging purposes, shows data in each cell
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            
            int borderingMines = grid[i][j].getBorderingMines();
            char charValue = grid[i][j].getCharToBeRenderedValue();
            boolean isFlagged = grid[i][j].getHasBeenClicked();
            boolean isMine = grid[i][j].isMine();
            String address = grid[i][j].getGridAddress();
            System.out.print("(" + borderingMines + "," + charValue + "," + isFlagged + "," + isMine + "," + address + ")");
        }
        System.out.println(); 
    }
}

public void printMineGridAddressGrid() {
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid.length; j++) {
			String address = grid[i][j].getGridAddress();
			System.out.print("   " + address); //3 spaces
		} 
		System.out.println();
	}
}


public void printMineGrid() {
	System.out.println(); 
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid.length; j++) {
			char charToBeRendered = grid[i][j].getCharToBeRenderedValue();
			System.out.print("   " + charToBeRendered); //3 spaces
		}
		System.out.println();
	}
}

public void printMineGridAdresses() {
	System.out.println(); 
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid.length; j++) {}
	}
}

public void revealAdjacentZeros(int x, int y) {
    
    if (x < 0 || x >= grid.length || y < 0 || y >= grid.length || grid[x][y].getHasBeenClicked() || grid[x][y].isMine()) {
        return;
    }
    grid[x][y].setHasBeenClicked(true);
    int borderingMines = grid[x][y].getBorderingMines();
    grid[x][y].setCharToBeRenderedValue(borderingMines > 0 ? (char) ('0' + borderingMines) : '0');
    if (borderingMines == 0) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue; 
                revealAdjacentZeros(x + dx, y + dy);
            }
        }
    }
}

public boolean selectTile(String selectedTile) {
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            String address = grid[i][j].getGridAddress();
            if (address.equals(selectedTile)) {
                if (grid[i][j].getHasBeenClicked()) {
                    System.out.println("This tile has already been selected. Please choose another.");
                    return true; 
                }
                
                if (grid[i][j].isMine()) {
                    grid[i][j].setHasBeenClicked(true);
                    System.out.println("Boom! Game over!!!");
                    return false; 
                } else {
                    
                    revealAdjacentZeros(i, j);
                    printMineGrid();
                    return true; 
                }
            }
        }
    }
    System.out.println("Invalid address entered. Please try again.");
    return true; 
}



public Cell getCell(int x, int y) {
    return grid[x][y];
}

public void setCell(int x, int y, Cell cell) {
    grid[x][y] = cell;
}

public Cell[][] getGrid() {
    return grid;
}


		
	}
