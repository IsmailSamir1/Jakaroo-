package model.card.standard;

import java.util.ArrayList;

import model.player.Marble;
import engine.GameManager;
import engine.board.BoardManager;
import exception.ActionException;
import exception.InvalidMarbleException;

public class Ace extends Standard {
	
	public Ace(String name, String description, Suit suit, BoardManager boardManager, GameManager gameManager){
		super(name,description,1, suit, boardManager, gameManager);
		
	}
	
	public boolean validateMarbleSize(ArrayList<Marble> marbles)
	{
		int size = marbles.size();
		if(size == 0 || size == 1)
			return true;
		return false;	
	}
	
	
	public void act(ArrayList<Marble> marbles) throws ActionException, InvalidMarbleException
	{
		if(!validateMarbleSize(marbles))
			throw new InvalidMarbleException("Number of marbles is incorrect");
		if(!validateMarbleColours(marbles))
			throw new InvalidMarbleException("Colours of marbles are incorrect");
		int size= marbles.size();
		if(size==0)	
			gameManager.fieldMarble();
		else
			boardManager.moveBy(marbles.get(0), 1, false);
	}
	

}
