package model.card.standard;

import java.util.ArrayList;

import model.Colour;
import model.card.Card;
import model.player.Marble;
import engine.GameManager;
import engine.board.Board;
import engine.board.BoardManager;
import exception.ActionException;
import exception.IllegalMovementException;
import exception.InvalidMarbleException;

public class Standard extends Card {
	private final int rank;
	private final Suit suit;
	 
	 public Standard(String name, String description, int rank, Suit suit, BoardManager boardManager, GameManager gameManager){
		 super(name,description, boardManager, gameManager);
		 this.rank=rank;
		 this.suit= suit;
	
	 }

	public int getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
	
	public void act(ArrayList<Marble> marbles) throws ActionException,
			InvalidMarbleException {
		if(!validateMarbleSize(marbles))
			throw new InvalidMarbleException("Number of marbles is incorrect");
		if(!validateMarbleColours(marbles))
			throw new InvalidMarbleException("Colours of marbles are incorrect");
		int steps= (rank==4)? -4: rank;
		boardManager.moveBy(marbles.get(0), steps, false);
	}

	 
}
