package engine;

import model.Colour;
import model.player.Marble;
import exception.CannotDiscardException;
import exception.CannotFieldException;
import exception.IllegalDestroyException;

public interface GameManager {
	 void sendHome(Marble marble);
	    void fieldMarble() throws CannotFieldException, IllegalDestroyException;
	    void discardCard(Colour colour) throws CannotDiscardException;
	    void discardCard() throws CannotDiscardException;
	    Colour getActivePlayerColour();
	    Colour getNextPlayerColour();

}
