package model.card;

import java.util.ArrayList;

import model.Colour;
import model.player.Marble;
import engine.GameManager;
import engine.board.BoardManager;
import exception.ActionException;
import exception.InvalidMarbleException;

public abstract class Card {
	private final String name;
	private final String description;
	 protected BoardManager boardManager;
	 protected GameManager gameManager;


	 public Card(String name,String description,BoardManager boardManager, GameManager gameManager){
		 
		this.name=name; 
		this.description=description;
		this.boardManager=boardManager;
		this.gameManager=gameManager;
		 
	 }


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}
	public boolean validateMarbleSize(ArrayList<Marble> marbles){
	return marbles.size()== 1;
	}
	public boolean validateMarbleColours(ArrayList<Marble> marbles){
		Colour activePlayerColour = gameManager.getActivePlayerColour();

	    for (Marble marble : marbles) {
	        if (!marble.getColour().equals(activePlayerColour)) {
	            return false; 
	        }
	    }
	    return true; 
	}
	
	public abstract void act(ArrayList<Marble> marbles) throws ActionException, InvalidMarbleException;
		 
	 
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

