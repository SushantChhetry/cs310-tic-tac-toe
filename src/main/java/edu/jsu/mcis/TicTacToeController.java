package edu.jsu.mcis;

import java.io.Console;

public class TicTacToeController {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView();
        
    }

    public void start() {
        /*
       /* MAIN LOOP (repeats until game is over) */
        int row = 0;
        int col = 0;
       
        /* Displays the board using the View's "showBoard()", then uses
           "getNextMove()" to get the next move from the player.  Enters
           the move (using the Model's "makeMark()", or displays an error
           using the View's "showInputError()" if the move is invalid. */
        
        while (model.isGameover() == false) {
            

            view.showBoard(model.toString());
            TicTacToeMove move = view.getNextMove(model.isXTurn());
            
            row = move.getRow();
            col = move.getCol(); 

            boolean isValidMove = model.makeMark(row, col);
			
            if (!isValidMove) {
                view.showInputError();
            }
          
        }
        
        /* After the game is over, shows the final board and the winner */

        view.showBoard(model.toString());

        view.showResult(model.getResult().toString());

}
}
