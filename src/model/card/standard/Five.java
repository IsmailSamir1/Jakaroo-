package model.card.standard;

import java.util.ArrayList;

import model.player.Marble;
import engine.GameManager;
import engine.board.BoardManager;
import exception.ActionException;
import exception.InvalidMarbleException;

public class Five extends Standard{
	public Five(String name, String description, Suit suit, BoardManager boardManager, GameManager
				 gameManager){
		super(name,description,5,suit, boardManager, gameManager);
	}
	
	public boolean validateMarbleColours(ArrayList<Marble> marbles){
		return true;
	}
	public void act(ArrayList<Marble> marbles) throws ActionException, InvalidMarbleException
	{
		if(!validateMarbleSize(marbles))
			throw new InvalidMarbleException("Number of marbles is incorrect");
		if(!validateMarbleColours(marbles))
			throw new InvalidMarbleException("Colours of marbles are incorrect");
		boardManager.moveBy(marbles.get(0), 5, false);
	}
}