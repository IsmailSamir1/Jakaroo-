package model.card.standard;

import java.util.ArrayList;

import model.player.Marble;
import engine.GameManager;
import engine.board.BoardManager;
import exception.ActionException;
import exception.InvalidMarbleException;

public class King extends Standard{
	
		
		public King(String name, String description, Suit suit, BoardManager boardManager, GameManager
				 gameManager){
			super(name,description,13, suit, boardManager, gameManager);
			
		}
		public boolean validateMarbleSize(ArrayList<Marble> marbles)
		{
			if(marbles.size()==1 || marbles.size() ==0) return true;
			return false;
		}
		
		public void act(ArrayList<Marble> marbles) throws ActionException, InvalidMarbleException
		{
			int size=marbles.size();
			if(!validateMarbleSize(marbles))
				throw new InvalidMarbleException("Number of marbles is incorrect");
			if(!validateMarbleColours(marbles))
				throw new InvalidMarbleException("Colours of marbles are incorrect");
			if(size==0)		
				gameManager.fieldMarble();
			else
				boardManager.moveBy(marbles.get(0), 13, true);
				
		}
		
		
	}


