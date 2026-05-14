package model.card.standard;

import java.util.ArrayList;

import model.Colour;
import model.player.Marble;
import engine.GameManager;
import engine.board.BoardManager;
import exception.ActionException;
import exception.InvalidMarbleException;

public class Jack extends Standard{
	public Jack (String name, String description, Suit suit, BoardManager boardManager, GameManager
 gameManager){
 super(name,description,11, suit, boardManager, gameManager);

}
	public boolean validateMarbleSize(ArrayList<Marble> marbles)
	{
		int size = marbles.size();
		if(size==2 || size ==1 )return true;
		return false;		// 0 , 1 
							// 1, 0
	}
	public boolean validateMarbleColours(ArrayList<Marble> marbles){
		Colour playerColour=  gameManager.getActivePlayerColour();
		if (marbles.size() == 2)
		{
			int counter=0 , counter2= 0;
			for(int i= 0; i<marbles.size();i++){
				if(marbles.get(i).getColour() == playerColour)
					counter++;
				else 
					counter2++;
			}
			return counter == counter2;
		}
			return marbles.get(0).getColour() == playerColour; 
		
	}
	public void act(ArrayList<Marble> marbles) throws ActionException, InvalidMarbleException
	{
		if(!validateMarbleSize(marbles))
			throw new InvalidMarbleException("Number of marbles is incorrect");
		if(!validateMarbleColours(marbles))
			throw new InvalidMarbleException("Colours of marbles are incorrect");
		int size=marbles.size();
		if(size==2)		
			boardManager.swap(marbles.get(0),marbles.get(1));
		else
			boardManager.moveBy(marbles.get(0),11 , false);
			
	}
	
}