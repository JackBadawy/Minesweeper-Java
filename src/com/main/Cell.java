package com.main;
public class Cell {
private int borderingMines;
private char charToBeRendered;
private boolean hasBeenClicked;
private boolean mine;
private String gridAddress;


public Cell(int borderingMines, char charToBeRendered, boolean hasBeenClicked, boolean mine, String gridAddress) {
	this.borderingMines = borderingMines;
	this.charToBeRendered = charToBeRendered;
	this.hasBeenClicked = hasBeenClicked;
	this.mine = mine;
	this.gridAddress = gridAddress;
}

public String getGridAddress() {
	return gridAddress;
}

public void setGridAddress(String gridAdress) {
	this.gridAddress = gridAdress;
}


public boolean getHasBeenClicked() {
	return hasBeenClicked;
}

public boolean isMine() {
	return mine;
}

public void setMine(boolean mine) {
	this.mine = mine;
}

public void setHasBeenClicked(boolean hasBeenClicked) {
	this.hasBeenClicked = hasBeenClicked;
}
// rename all the below
public int getBorderingMines() {
	return borderingMines;
}

public void setBorderingMines(int borderingMines) {
	this.borderingMines = borderingMines;
}

public char getCharToBeRenderedValue() {
	return charToBeRendered;
}

public void setCharToBeRenderedValue(char charToBeRendered) {
	this.charToBeRendered = charToBeRendered;
}




}
